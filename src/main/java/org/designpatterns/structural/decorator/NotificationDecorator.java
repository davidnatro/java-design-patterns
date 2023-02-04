package org.designpatterns.structural.decorator;

public abstract class NotificationDecorator implements Notification {
    protected final Notification notification;

    public NotificationDecorator(final Notification notification) {
        this.notification = notification;
    }

    @Override
    public void notifySubscriber() {
        notification.notifySubscriber();
    }
}
