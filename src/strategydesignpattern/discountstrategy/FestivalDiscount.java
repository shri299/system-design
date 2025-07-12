package strategydesignpattern.discountstrategy;

public class FestivalDiscount implements DiscountStrategy{
    @Override
    public int getNetCost(int cost) {
        return cost-50;
    }
}
