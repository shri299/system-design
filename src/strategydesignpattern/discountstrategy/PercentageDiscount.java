package strategydesignpattern.discountstrategy;

public class PercentageDiscount implements DiscountStrategy{
    @Override
    public int getNetCost(int cost) {
        return cost - (cost*10)/100;
    }
}
