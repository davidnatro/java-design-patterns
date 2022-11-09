package org.designpatterns.abstract_factory;

public class SamsungFactory implements TechFactory {
    @Override
    public Computer produceComputer() {
        return new SamsungComputer();
    }

    @Override
    public Phone producePhone() {
        return new SamsungPhone();
    }
}

class SamsungPhone extends Phone {
    @Override
    public String toString() {
        return "Samsung phone";
    }
}

class SamsungComputer extends Computer {
    @Override
    public String toString() {
        return "Samsung computer";
    }
}