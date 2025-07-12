package strategydesignpattern.discountstrategy;

public class DiscountContext {

    private DiscountStrategy strategy;

    public void setStrategy(DiscountStrategy strategy){
        this.strategy=strategy;
    }

    public int calcFinalCost(int cost){
        return this.strategy.getNetCost(cost);
    }
}
