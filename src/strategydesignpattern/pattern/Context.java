package strategydesignpattern.pattern;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performAction() {
        strategy.selectAlgo();
    }
}
