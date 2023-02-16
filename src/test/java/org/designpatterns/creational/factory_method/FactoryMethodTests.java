package org.designpatterns.creational.factory_method;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.UUID;

public class FactoryMethodTests {
    @Test
    public void orderTruckTest() {
        Factory factory = new Factory();

        Transport truck = factory.order("truck");

        Assertions.assertNotNull(truck);
        Assertions.assertInstanceOf(Transport.class, truck);
        Assertions.assertInstanceOf(Truck.class, truck);
    }

    @Test
    public void orderPlaneTest() {
        Factory factory = new Factory();

        Transport plane = factory.order("plane");

        Assertions.assertNotNull(plane);
        Assertions.assertInstanceOf(Transport.class, plane);
        Assertions.assertInstanceOf(Plane.class, plane);
    }

    @Test
    public void illegalFactoryArgumentTest() {
        Factory factory = new Factory();

        Assertions.assertThrows(IllegalArgumentException.class, () -> factory.order(UUID.randomUUID().toString()));
    }

    @Test
    public void nullFactoryArgumentTest() {
        Factory factory = new Factory();

        Assertions.assertThrows(IllegalArgumentException.class, () -> factory.order(null));
    }

    @Test
    public void deliverByTruckTest() {
        Factory factory = new Factory();

        Transport truck = factory.order("truck");

        final String expectedResult = "Your order will be delivered by Truck!";

        Assertions.assertEquals(expectedResult, truck.deliver());
    }

    @Test
    public void deliverByTruckPlane() {
        Factory factory = new Factory();

        Transport plane = factory.order("plane");

        final String expectedResult = "Your order will be delivered by Plane!";

        Assertions.assertEquals(expectedResult, plane.deliver());
    }
}
