package decoraterpattern.extratopping;

import decoraterpattern.base.Base;

public class MushroomToppings extends Toppings{

    private Base base;

    public MushroomToppings (Base base){
        this.base=base;
    }
    @Override
    public int cost() {
        return base.cost() + 50;
    }
}
