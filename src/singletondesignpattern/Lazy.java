package singletondesignpattern;

public class Lazy {

    private static Lazy lazy;

    private Lazy (){

    }

    //concurrent threads trying to access this, will result in creation of multiple objects
    //we resolve this using synchronized
    public static Lazy getInstance(){ //lazy initialization
        if (lazy==null){
            lazy = new Lazy();
        }
        return lazy;
    }
}
