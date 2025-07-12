package strategydesignpattern.pattern;

public class Demo {

    public static void main(String[] args) {
        // You decide the strategy based on user choice or config
        Strategy strategy = new StrategyImpl1();
        // Inject into context
        Context context = new Context(strategy);
        // Context is now using that strategy
        context.performAction();
    }
}
