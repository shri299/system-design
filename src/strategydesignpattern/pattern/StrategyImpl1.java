package strategydesignpattern.pattern;

public class StrategyImpl1 implements Strategy{
    @Override
    public void selectAlgo() {
        System.out.println("First Implementation");
    }
}
