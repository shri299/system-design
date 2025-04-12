package Java.multithreading.ThreadCreation;

import java.sql.Time;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting main method: "+Thread.currentThread().getName());

        //Thread creation by implementing Runnable
//        MultiThreading multiThreading = new MultiThreading();
//        Thread thread = new Thread(multiThreading);
//        thread.start();

        //Thread creation by directly extending the thread class
        ExtendingFromThread extendingFromThread = new ExtendingFromThread();
        extendingFromThread.start();
        System.out.println("Finished main method: "+Thread.currentThread().getName());
    }
}
