package org.designpatterns.structural.decorator;

public class EmailNotifier extends NotificationDecorator {
    public EmailNotifier(Notification notification) {
        super(notification);
    }

    @Override
    public void notifySubscriber() {
        notification.notifySubscriber();
        emailNotification();
    }

    private void emailNotification() {
        System.out.println("Email notification!");
    }
}
