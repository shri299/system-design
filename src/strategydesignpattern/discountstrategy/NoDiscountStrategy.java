package strategydesignpattern.discountstrategy;

public class NoDiscountStrategy implements DiscountStrategy{
    @Override
    public int getNetCost(int cost) {
        return cost;
    }
}
