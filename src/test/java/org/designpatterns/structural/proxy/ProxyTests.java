package org.designpatterns.structural.proxy;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ProxyTests {
    @Test
    public void cacheTests() {
        ThirdPartyLib lib = new ThirdPartyClass();
        ThirdPartyLib proxyLib = new ThirdPartyClassProxy();

        Assertions.assertNotEquals(lib.getData(), lib.getData());
        Assertions.assertEquals(proxyLib.getData(), proxyLib.getData());
    }
}
