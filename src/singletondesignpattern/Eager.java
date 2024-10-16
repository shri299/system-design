package singletondesignpattern;

public class Eager {

    //eager initialization
    private static Eager eager  = new Eager(); //make this instance static, so that only access through clas name

    private Eager (){ //make constructor private so that no one can call it from the outside

    }

    public Eager getInstance(){ //expose method to return a single object of this class
        return eager;
    }
}
