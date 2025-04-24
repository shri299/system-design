package Java.multithreading.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        //whe you'll keep reentrant lock common, only one thread will enter irrespective of shared resource object
        //But, of you'll keep the reentrant object, in shared res class, this will not work, the lock object shd be common.
        ReentrantLock lock = new ReentrantLock();

        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(()->{
            sharedResource.producer(lock);
        });

        SharedResource sharedResource1 = new SharedResource();
        Thread thread2 = new Thread(()->{
            sharedResource1.producer(lock);
        });

        thread1.start();
        thread2.start();
    }
}
