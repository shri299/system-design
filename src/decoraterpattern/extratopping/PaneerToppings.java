package decoraterpattern.extratopping;

import decoraterpattern.base.Base;

public class PaneerToppings extends Toppings{

    private Base base;

    public PaneerToppings (Base base){
        this.base=base;
    }

    @Override
    public int cost() {
        return base.cost() + 70;
    }
}
