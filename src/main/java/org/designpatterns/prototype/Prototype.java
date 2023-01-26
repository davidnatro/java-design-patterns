package org.designpatterns.prototype;

public class Prototype implements IPrototype<Prototype> {
    private long id;

    private static int idNumber = 0;

    public Prototype() {
        id = ++idNumber;
    }

    private Prototype(final long id) {
        this.id = id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    @Override
    public Prototype getPrototype() {
        return new Prototype(this.id);
    }

    @Override
    public String toString() {
        return String.format("User #%d", id);
    }
}
