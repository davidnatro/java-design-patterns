package org.designpatterns.object_pool;

public class PooledObject {
    private final int id;

    private static int number = 0;

    public PooledObject() {
        id = ++number;
    }

    @Override
    public String toString() {
        return "Object #" + id;
    }
}
