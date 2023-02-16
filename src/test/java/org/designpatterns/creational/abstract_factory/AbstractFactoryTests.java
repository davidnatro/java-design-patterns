package org.designpatterns.creational.abstract_factory;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AbstractFactoryTests {
    @Test
    public void appleFactoryTest() {
        TechFactory factory = new AppleFactory();

        Phone phone = factory.producePhone();
        Computer computer = factory.produceComputer();

        Assertions.assertInstanceOf(Phone.class, phone);
        Assertions.assertInstanceOf(ApplePhone.class, phone);

        Assertions.assertInstanceOf(Computer.class, computer);
        Assertions.assertInstanceOf(AppleComputer.class, computer);
    }

    @Test
    public void samsungFactoryTest() {
        TechFactory factory = new SamsungFactory();

        Phone phone = factory.producePhone();
        Computer computer = factory.produceComputer();

        Assertions.assertInstanceOf(Phone.class, phone);
        Assertions.assertInstanceOf(SamsungPhone.class, phone);

        Assertions.assertInstanceOf(Computer.class, computer);
        Assertions.assertInstanceOf(SamsungComputer.class, computer);
    }
}
