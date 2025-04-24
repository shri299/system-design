package Java.multithreading.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isAvailable=false;

    public void producer(ReentrantLock lock){
        try {
            lock.lock();
            System.out.println("lock acquired by: "+Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(4000);
        }catch (Exception e){
            //throw exception
        }finally {
            System.out.println("releasing lock for: "+Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
