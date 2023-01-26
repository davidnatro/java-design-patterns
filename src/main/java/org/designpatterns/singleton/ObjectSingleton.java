package org.designpatterns.singleton;

public class ObjectSingleton {
    private static volatile Object data = null;

    private ObjectSingleton() { }

    public static synchronized Object getData() {
        if (data == null) {
            data = new Object();
        }

        return data;
    }
}
