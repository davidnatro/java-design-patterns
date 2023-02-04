package org.designpatterns.structural.decorator;

public class SmsNotifier extends NotificationDecorator {
    public SmsNotifier(Notification notification) {
        super(notification);
    }

    @Override
    public void notifySubscriber() {
        notification.notifySubscriber();
        smsNotification();
    }

    private void smsNotification() {
        System.out.println("Sms notification!");
    }
}
