package factorypattern.notifcationsystem;

public class Demo {

    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.getNotifyObj("EMAIL");
        notification.notifyUser();
    }
}
