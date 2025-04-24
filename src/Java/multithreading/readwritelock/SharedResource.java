package Java.multithreading.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    public void produce(ReadWriteLock lock){
        try {
            lock.readLock().lock();
            System.out.println("Acquiring the read lock: "+Thread.currentThread().getName());
            Thread.sleep(8000);
        }catch (Exception e){
            //something
        }finally {
            System.out.println("Releasing the read lock: "+Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }

    public void consumer(ReadWriteLock lock){
        try {
            lock.writeLock().lock();
            System.out.println("Acquiring the write lock: "+Thread.currentThread().getName());
        }catch (Exception e){
            //something
        }finally {
            System.out.println("Releasing the write lock: "+Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }
}
