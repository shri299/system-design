package singletondesignpattern;

public class SynchronizedMethod {

    private static SynchronizedMethod asynchronized;

    private SynchronizedMethod(){

    }

    //puts a lock at every thread
    //can be costly and can act as a bottleneck
    synchronized public static SynchronizedMethod getInstance(){ //lazy initialization
        if (asynchronized==null){
            asynchronized = new SynchronizedMethod();
        }
        return asynchronized;
    }
}
