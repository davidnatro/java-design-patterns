package org.designpatterns.creational.object_pool;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ObjectPool {
    private final Queue<PooledObject> objects;
    private final List<PooledObject> inUseObjects;

    private LinkedBlockingQueue<PooledObject> objects2;

    public ObjectPool(final int poolSize) throws IllegalArgumentException {
        if (poolSize <= 0) {
            throw new IllegalArgumentException("Invalid pool size!");
        }

        objects = new ArrayDeque<PooledObject>(poolSize);
        inUseObjects = new ArrayList<PooledObject>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            objects.add(new PooledObject());
        }
    }

    public synchronized PooledObject getObject() {
        PooledObject object;
        while ((object = objects.poll()) == null) {
            try {
                wait();
            } catch (final InterruptedException exception) {
                System.out.println(exception.getMessage());
            }
        }

        inUseObjects.add(object);

        return object;
    }

    public synchronized void returnObject(final PooledObject object) {
        if (object == null) {
            return;
        }

        inUseObjects.remove(object);
        objects.add(object);

        notifyAll();
    }
}
