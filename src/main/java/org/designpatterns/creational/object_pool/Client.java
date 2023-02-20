package org.designpatterns.creational.object_pool;

public class Client implements Runnable {
    private final ObjectPool pool;

    private final int id;

    private static int number = 0;

    public Client(final ObjectPool pool) {
        this.id = ++number;
        this.pool = pool;
    }

    private PooledObject getObjectFromPool() {
        PooledObject object = pool.getObject();
        System.out.println(this + " gets " + object);

        return object;

    }

    private void returnObjectToPool(final PooledObject object) {
        pool.returnObject(object);
        System.out.println(this + " returns " + object);
    }

    @Override
    public void run() {
        PooledObject object = getObjectFromPool();

        try {
            Thread.sleep(0);
        } catch (final InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

        returnObjectToPool(object);
    }

    @Override
    public String toString() {
        return "User #" + id;
    }
}
