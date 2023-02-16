import org.designpatterns.creational.builder.CustomEmployeeBuilder;
import org.designpatterns.creational.builder.EmployeeBuilder;
import org.designpatterns.creational.builder.EmployeeDirector;
import org.designpatterns.creational.builder.Position;
import org.designpatterns.creational.object_pool.Client;
import org.designpatterns.creational.object_pool.ObjectPool;
import org.designpatterns.structural.bridge.BridgeForOS;
import org.designpatterns.structural.bridge.MacOS;
import org.designpatterns.structural.bridge.OperationalSystem;
import org.designpatterns.structural.bridge.Windows;
import org.designpatterns.structural.decorator.EmailNotifier;
import org.designpatterns.structural.decorator.Notification;
import org.designpatterns.structural.decorator.Notifier;
import org.designpatterns.structural.decorator.SmsNotifier;
import org.designpatterns.structural.facade.FacadeForThirdPartyLib;
import org.designpatterns.structural.flyweight.Bullet;
import org.designpatterns.structural.flyweight.BulletFactory;
import org.designpatterns.structural.proxy.ThirdPartyClassProxy;
import org.designpatterns.structural.proxy.ThirdPartyLib;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Program {
    private static void objectPool() {
        ObjectPool pool = new ObjectPool(2);

        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            es.execute(new Thread(new Client(pool)));
        }
        es.shutdown();
        try {
            if (es.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Object pool pattern implemented!");
            }
        } catch (InterruptedException exception) {
            System.out.println(exception.getMessage());
            return;
        }
    }

    private static void bridge() {
        OperationalSystem system = new MacOS();
        BridgeForOS bridge = new BridgeForOS(system);
        bridge.run();

        system = new Windows();
        bridge = new BridgeForOS(system);
        bridge.run();
    }

    private static void facade() {
        FacadeForThirdPartyLib facade = new FacadeForThirdPartyLib();
        facade.method2();
        facade.method3();
    }

    private static void decorator() {
        Notification mainNotifier = new Notifier();
        Notification smsNotifier = new SmsNotifier(new Notifier());
        Notification emailNotifier = new EmailNotifier(new Notifier());

        System.out.println("Main obj: ");
        mainNotifier.notifySubscriber();

        System.out.println("SmsDecorator obj: ");
        smsNotifier.notifySubscriber();

        System.out.println("EmailDecorator obj: ");
        emailNotifier.notifySubscriber();
    }

    private static void proxy() {
        final ThirdPartyLib lib = new ThirdPartyClassProxy();
        for (int i = 0; i < 3; i++) {
            System.out.println(lib.getData());
        }
    }

    private static void flyweight() {
        BulletFactory factory = new BulletFactory();

        Bullet fisrtBullet = factory.getBullet();
        fisrtBullet.setX(1);
        fisrtBullet.setY(1);

        Bullet secondBullet = factory.getBullet();
        secondBullet.setX(0);
        secondBullet.setX(0);

        System.out.println(fisrtBullet);
        System.out.println(secondBullet);
    }

    public static void main(String[] args) {
        // Object pool
        System.out.println("== Object pool ==");

        objectPool();

        System.out.println("==========\n");

        // Bridge
        System.out.println("== Bridge ==");

        bridge();

        System.out.println("==========\n");

        // Facade
        System.out.println("== Facade ==");

        facade();

        System.out.println("==========\n");

        // Decorator
        System.out.println("== Decorator ==");

        decorator();

        System.out.println("==========\n");

        // Proxy
        System.out.println("== Proxy ==");

        proxy();

        System.out.println("==========\n");

        // Flyweight
        System.out.println("== Flyweight ==");

        flyweight();

        System.out.println("==========\n");
    }
}