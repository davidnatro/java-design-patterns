package org.designpatterns;

import org.designpatterns.creational.abstract_factory.AppleFactory;
import org.designpatterns.creational.abstract_factory.SamsungFactory;
import org.designpatterns.creational.abstract_factory.TechFactory;
import org.designpatterns.creational.builder.CustomEmployeeBuilder;
import org.designpatterns.creational.builder.EmployeeBuilder;
import org.designpatterns.creational.builder.EmployeeDirector;
import org.designpatterns.creational.builder.Position;
import org.designpatterns.creational.factory_method.Factory;
import org.designpatterns.creational.lazy_initialization.LazyObject;
import org.designpatterns.creational.object_pool.Client;
import org.designpatterns.creational.object_pool.ObjectPool;
import org.designpatterns.creational.prototype.IPrototype;
import org.designpatterns.creational.prototype.Prototype;
import org.designpatterns.structural.adapter.PrintProductAdapter;
import org.designpatterns.structural.adapter.Product;
import org.designpatterns.structural.bridge.BridgeForOS;
import org.designpatterns.structural.bridge.MacOS;
import org.designpatterns.structural.bridge.OperationalSystem;
import org.designpatterns.structural.bridge.Windows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static void abstractFactory() {
        TechFactory appleFactory = new AppleFactory();
        TechFactory samsungFactory = new SamsungFactory();

        System.out.println(appleFactory.producePhone());
        System.out.println(appleFactory.produceComputer());

        System.out.println(samsungFactory.producePhone());
        System.out.println(samsungFactory.produceComputer());
    }

    private static void builder() {
        EmployeeBuilder buildSettings = new CustomEmployeeBuilder();
        buildSettings
                .setId(1)
                .setFullName("FirstName LastName")
                .setPosition(Position.Programmer);

        EmployeeDirector director = new EmployeeDirector(buildSettings);
        director.build();

        System.out.println(director.getEmployee());
    }

    private static void factoryMethod() {
        Factory factory = new Factory();

        try {
            System.out.println(factory.order("truck").deliver());
            System.out.println(factory.order("plane").deliver());
            System.out.println(factory.order("car").deliver());
            System.out.println(factory.order(null).deliver());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void lazyInitialization() {
        LazyObject lazyObject = new LazyObject();
        System.out.print("Lazy: ");
        lazyObject.lazy();
        System.out.print("Not lazy: ");
        lazyObject.notLazy();
    }

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

    private static void prototype() {
        IPrototype<Prototype> main = new Prototype();
        System.out.println(main);
        var copy = main.getPrototype();
        copy.setId(5);
        System.out.println(copy);
        System.out.println(copy.getPrototype());
    }

    private static void adapter() {
        PrintProductAdapter adapter = new PrintProductAdapter(new Product("Product #1", 55.5));
        adapter.print();
    }

    private static void bridge() {
        OperationalSystem system = new MacOS();
        BridgeForOS bridge = new BridgeForOS(system);
        bridge.run();

        system = new Windows();
        bridge = new BridgeForOS(system);
        bridge.run();
    }

    public static void main(String[] args) {
        // Abstract factory
        System.out.println("== Abstract factory ==");

        abstractFactory();

        System.out.println("==========\n");

        // Builder
        System.out.println("== Builder ==");

        builder();

        System.out.println("==========\n");

        // Factory method
        System.out.println("== Factory method ==");

        factoryMethod();

        System.out.println("==========\n");


        // Lazy initialization
        System.out.println("== Lazy initialization ==");

        lazyInitialization();

        System.out.println("==========\n");

        // Object pool
        System.out.println("== Object pool ==");

        objectPool();

        System.out.println("==========\n");

        // Prototype
        System.out.println("== Prototype ==");

        prototype();

        System.out.println("==========\n");

        // Adapter
        System.out.println("== Adapter ==");

        adapter();

        System.out.println("==========\n");

        // Bridge
        System.out.println("== Bridge ==");

        bridge();

        System.out.println("==========\n");
    }
}