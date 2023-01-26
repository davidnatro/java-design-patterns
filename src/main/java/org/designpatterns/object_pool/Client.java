package org.designpatterns.object_pool;

public class Client implements Runnable {
    private final ObjectPool pool;

    private final int id;

    private static int number = 0;

    public Client(final ObjectPool pool) {
        this.id = ++number;
        this.pool = pool;
    }

    private PooledObject getObjectFromPool() {
        synchronized (pool) {
            PooledObject object;

            while ((object = pool.getObject()) == null) {
                try {
                    pool.wait();
                } catch (final InterruptedException exception) {
                    System.out.println(exception.getMessage());
                }
            }

            System.out.println(this + " gets " + object);

            return object;
        }
    }

    private void returnObjectToPool(final PooledObject object) {
        synchronized (pool) {
            pool.returnObject(object);
            System.out.println(this + " returns " + object);
            pool.notifyAll();
        }
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
