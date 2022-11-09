package org.designpatterns;

import org.designpatterns.abstract_factory.AppleFactory;
import org.designpatterns.abstract_factory.SamsungFactory;
import org.designpatterns.abstract_factory.TechFactory;

public class Main {
    public static void main(String[] args) {
        // Abstract factory
        TechFactory appleFactory = new AppleFactory();
        TechFactory samsungFactory = new SamsungFactory();

        System.out.println(appleFactory.producePhone());
        System.out.println(appleFactory.produceComputer());

        System.out.println(samsungFactory.producePhone());
        System.out.println(samsungFactory.produceComputer());
    }
}