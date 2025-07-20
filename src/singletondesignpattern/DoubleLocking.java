package singletondesignpattern;

public class DoubleLocking {

    private static DoubleLocking doubleLocking;
    //can make this variable volatile
    //since new obj creation is a multiple step process
    //and due to out of order execution by jvm, there is chance thread 2 get doubleLocking not null, even b4 its initialised.

    private DoubleLocking (){

    }

    public static DoubleLocking getInstance(){
        if (doubleLocking==null){
            synchronized (DoubleLocking.class){ //only one thread will go inside and make the obj not null, sorted of all other threads
                if (doubleLocking==null){
                    doubleLocking = new DoubleLocking();
                }
            }
        }
        return doubleLocking;
    }
}
