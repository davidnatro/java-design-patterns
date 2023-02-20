package org.designpatterns.structural.bridge;

public class Windows implements OperationalSystem {
    @Override
    public OS run() {
        return OS.WINDOWS;
    }
}
