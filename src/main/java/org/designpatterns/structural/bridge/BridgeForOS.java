package org.designpatterns.structural.bridge;

public class BridgeForOS implements OperationalSystem {
    private final OperationalSystem operationalSystem;

    public BridgeForOS(final OperationalSystem operationalSystem) {
        this.operationalSystem = operationalSystem;
    }

    @Override
    public OS run() {
        return operationalSystem.run();
    }
}
