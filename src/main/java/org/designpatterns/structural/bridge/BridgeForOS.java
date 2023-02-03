package org.designpatterns.structural.bridge;

public class BridgeForOS {
    private final OperationalSystem operationalSystem;

    public BridgeForOS(final OperationalSystem operationalSystem) {
        this.operationalSystem = operationalSystem;
    }

    public void run() {
        operationalSystem.run();
    }
}
