package org.designpatterns.creational.factory_method;

public class Factory {
    public Transport order(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Null string!");
        }

        input = input.toUpperCase();

        return switch (input) {
            case "TRUCK" -> new Truck();
            case "PLANE" -> new Plane();
            default -> throw new IllegalArgumentException("There is no such a transport!");
        };
    }
}
