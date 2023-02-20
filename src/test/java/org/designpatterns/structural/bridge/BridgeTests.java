package org.designpatterns.structural.bridge;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BridgeTests {
    @Test
    public void bridgeTests() {
        OperationalSystem bridgeWithMacOS = new BridgeForOS(new MacOS());
        OperationalSystem bridgeWithWindows = new BridgeForOS(new Windows());

        Assertions.assertEquals(bridgeWithMacOS.run(), OS.MACOS);
        Assertions.assertEquals(bridgeWithWindows.run(), OS.WINDOWS);
    }
}
