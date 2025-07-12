package strategydesignpattern.travelrouteplanner;

public class Demo {
    public static void main(String[] args) {
        TravelStrategy strategy = new CarTravelStrategy();
        TravelContext context = new TravelContext(strategy);
        context.calculate(10);
    }
}
