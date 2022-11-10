package org.designpatterns.factory_method;

public abstract class Transport {
    public String deliver() {
        return "Your order will be delivered by " + this + "!";
    }

    @Override
    public abstract String toString();
}
