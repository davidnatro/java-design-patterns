package org.designpatterns;

import org.designpatterns.abstract_factory.AppleFactory;
import org.designpatterns.abstract_factory.SamsungFactory;
import org.designpatterns.abstract_factory.TechFactory;
import org.designpatterns.builder.CustomEmployeeBuilder;
import org.designpatterns.builder.EmployeeBuilder;
import org.designpatterns.builder.EmployeeDirector;
import org.designpatterns.builder.Position;

public class Main {
    public static void main(String[] args) {
        // Abstract factory
        System.out.println("== Abstract factory ==");

        TechFactory appleFactory = new AppleFactory();
        TechFactory samsungFactory = new SamsungFactory();

        System.out.println(appleFactory.producePhone());
        System.out.println(appleFactory.produceComputer());

        System.out.println(samsungFactory.producePhone());
        System.out.println(samsungFactory.produceComputer());

        System.out.println("==========\n");

        // Builder
        System.out.println("== Builder ==");
        EmployeeBuilder buildSettings = new CustomEmployeeBuilder();
        buildSettings
                .setId(1)
                .setFullName("FirstName LastName")
                .setPosition(Position.Programmer);

        EmployeeDirector director = new EmployeeDirector(buildSettings);
        director.build();

        System.out.println(director.getEmployee());

        System.out.println("==========");
    }
}