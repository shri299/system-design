package Java.multithreading.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();

        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(()->{
            sharedResource.produce(lock);
        });

        Thread t2 = new Thread(()->{
            sharedResource.produce(lock);
        });

        SharedResource sharedResource2 = new SharedResource();
        Thread t3 = new Thread(()->{
            sharedResource2.consumer(lock);
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
