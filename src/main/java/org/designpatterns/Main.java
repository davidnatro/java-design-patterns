package org.designpatterns;

import org.designpatterns.abstract_factory.AppleFactory;
import org.designpatterns.abstract_factory.SamsungFactory;
import org.designpatterns.abstract_factory.TechFactory;
import org.designpatterns.builder.CustomEmployeeBuilder;
import org.designpatterns.builder.EmployeeBuilder;
import org.designpatterns.builder.EmployeeDirector;
import org.designpatterns.builder.Position;
import org.designpatterns.factory_method.Factory;
import org.designpatterns.lazy_initialization.LazyObject;
import org.designpatterns.object_pool.Client;
import org.designpatterns.object_pool.ObjectPool;

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

        System.out.println("==========\n");
    }
}