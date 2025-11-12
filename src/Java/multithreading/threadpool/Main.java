package Java.multithreading.threadpool;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10,
                TimeUnit.MINUTES,new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i=0;i<7;i++){
            int finalI = i;
            executor.submit(()->{
                System.out.println("Task: " + finalI +" Thread: "+Thread.currentThread().getName());
            });
        }

    }
}

