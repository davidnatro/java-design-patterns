package org.designpatterns.creational.singleton;

import org.designpatterns.creational.singleton.ObjectSingleton;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SingletonTests {
    @Test
    public void singleInstanceTest() {
        Object firstInstance = ObjectSingleton.getData();
        Object secondInstance = ObjectSingleton.getData();

        Assertions.assertSame(firstInstance, secondInstance);
    }

    @Test
    public void lazyInitializationTest() {
        Object instance = null;
        instance = ObjectSingleton.getData();

        Assertions.assertNotNull(instance);
    }
}
