package org.designpatterns.abstract_factory;

public class AppleFactory implements TechFactory {
    @Override
    public Computer produceComputer() {
        return new AppleComputer();
    }

    @Override
    public Phone producePhone() {
        return new ApplePhone();
    }
}

class ApplePhone extends Phone {
    @Override
    public String toString() {
        return "Apple phone";
    }
}

class AppleComputer extends Computer {
    @Override
    public String toString() {
        return "Apple computer";
    }
}