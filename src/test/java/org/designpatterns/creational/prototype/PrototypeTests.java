package org.designpatterns.creational.prototype;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PrototypeTests {
    @Test
    public void prototypeTest() {
        Prototype original = new Prototype();
        Prototype prototype = original.getPrototype();

        Assertions.assertEquals(original.getId(), prototype.getId());
        Assertions.assertNotSame(original, prototype);
    }
}
