package org.designpatterns.structural.decorator;

public class Notifier implements Notification {
    @Override
    public void notifySubscriber() {
        System.out.println("Main notification!");
    }
}
