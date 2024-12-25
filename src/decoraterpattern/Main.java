package decoraterpattern;

import decoraterpattern.base.Base;
import decoraterpattern.base.VeggieBase;
import decoraterpattern.extratopping.MushroomToppings;

public class Main {

    public static void main(String[] args) {
        Base base = new MushroomToppings(new VeggieBase());
        System.out.println(base.cost());
    }
}
