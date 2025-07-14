package factorypattern.notifcationsystem;

public class NotificationFactory {
    public Notification getNotifyObj(String type){
        if (type == null) return null;
        switch (type.toUpperCase()) {
            case "SMS": return new SMSNotification();
            case "PUSH": return new PushNotification();
            case "EMAIL": return new EmailNotification();
            default: return null;
        }
    }
}
