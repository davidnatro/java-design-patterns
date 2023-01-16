package org.designpatterns.object_pool;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ObjectPool {
    private final Queue<PooledObject> objects;
    private final List<PooledObject> inUseObjects;

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
        PooledObject object = objects.poll();

        if (object != null) {
            inUseObjects.add(object);
        }

        return object;
    }

    public synchronized void returnObject(final PooledObject object) {
        if (object == null) {
            return;
        }

        inUseObjects.remove(object);
        objects.add(object);
    }
}
