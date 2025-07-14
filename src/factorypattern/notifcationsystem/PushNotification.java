package factorypattern.notifcationsystem;

public class PushNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("PUSH");
    }
}
