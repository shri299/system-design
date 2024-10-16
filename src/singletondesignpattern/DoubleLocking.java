package singletondesignpattern;

public class DoubleLocking {

    private static DoubleLocking doubleLocking;

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
