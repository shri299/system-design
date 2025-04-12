package Java.multithreading.ThreadCreation;

public class ExtendingFromThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread creation by extending the thread class directly: "+Thread.currentThread().getName());
    }
}
