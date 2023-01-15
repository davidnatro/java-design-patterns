package org.designpatterns.object_pool;

public class PooledObject {
    private final int id;

    private static int number = 0;

    private String data;

    public PooledObject() {
        id = ++number;
    }

    public String getData() {
        return data;
    }

    public void setData(final String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Object #" + id;
    }
}
