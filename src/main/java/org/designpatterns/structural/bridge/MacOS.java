package org.designpatterns.structural.bridge;

public class MacOS implements OperationalSystem {
    @Override
    public OS run() {
        return OS.MACOS;
    }
}
