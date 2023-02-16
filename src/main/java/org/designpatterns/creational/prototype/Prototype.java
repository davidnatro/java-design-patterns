package org.designpatterns.creational.prototype;

public class Prototype implements IPrototype<Prototype> {
    private long id;

    private static long idNumber = 0;

    public Prototype() {
        id = ++idNumber;
    }

    public long getId() {
        return id;
    }

    private void setId(final long id) {
        this.id = id;
    }

    @Override
    public Prototype getPrototype() {
        Prototype prototype = new Prototype();
        prototype.setId(id);

        return prototype;
    }

    @Override
    public String toString() {
        return String.format("User #%d", id);
    }
}
