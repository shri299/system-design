package strategydesignpattern.discountstrategy;

public class FlatDiscount implements DiscountStrategy{
    @Override
    public int getNetCost(int cost) {
        return cost-50;
    }
}
