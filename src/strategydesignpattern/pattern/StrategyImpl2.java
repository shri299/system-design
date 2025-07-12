package strategydesignpattern.pattern;

public class StrategyImpl2 implements Strategy{
    @Override
    public void selectAlgo() {
        System.out.println("Second Implementation");
    }
}
