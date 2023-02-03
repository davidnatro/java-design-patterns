package org.designpatterns.structural.bridge;

public class MacOS implements OperationalSystem {
    @Override
    public void run() {
        System.out.println("MacOS running...");
    }
}
