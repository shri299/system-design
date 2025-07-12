package strategydesignpattern.travelrouteplanner;

public class TravelContext {

    private TravelStrategy travelStrategy;

    public TravelContext (TravelStrategy strategy){
        this.travelStrategy=strategy;
    }

    //can also use a set strategy function instead of creating new obj of this class again and again in demo
    public void setTravelStrategy(TravelStrategy strategy){
        this.travelStrategy=strategy;
    }

    public void calculate(int dist){
        this.travelStrategy.calcTimeCost(dist);
    }
}
