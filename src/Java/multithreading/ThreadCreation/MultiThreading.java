package Java.multithreading.ThreadCreation;

public class MultiThreading implements Runnable{
    @Override
    public void run() {
        System.out.println("The thread is running: "+Thread.currentThread().getName());
    }
}
