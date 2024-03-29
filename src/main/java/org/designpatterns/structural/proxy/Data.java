package org.designpatterns.structural.proxy;

public class Data {
    private static long idCount = 0;

    private final long id = ++idCount;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Data #" + getId();
    }
}
