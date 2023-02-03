package org.designpatterns.structural.bridge;

public class Windows implements OperationalSystem {
    @Override
    public void run() {
        System.out.println("Windows running...");
    }
}
