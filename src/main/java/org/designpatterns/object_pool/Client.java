package org.designpatterns.object_pool;

public class Client implements Runnable {
    private final ObjectPool pool;

    private final int id;

    private static int number = 0;

    public Client(final ObjectPool pool) {
        this.id = ++number;

        this.pool = pool;
    }

    private synchronized PooledObject getObjectFromPool() {
        while (pool.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException exception) {
                System.out.println(exception.getMessage());
            }
        }

        PooledObject object = pool.getObject();

        System.out.println(this + " gets " + object);

        return object;
    }

    private synchronized void returnObjectToPool(final PooledObject object) {
        pool.returnObject(object);
        System.out.println(this + " returns " + object);
        notifyAll();
    }

    @Override
    public void run() {
        returnObjectToPool(getObjectFromPool());
    }

    @Override
    public String toString() {
        return "User #" + id;
    }
}
