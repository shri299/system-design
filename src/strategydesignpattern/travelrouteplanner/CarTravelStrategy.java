package strategydesignpattern.travelrouteplanner;

public class CarTravelStrategy implements TravelStrategy{
    @Override
    public void calcTimeCost(int distance) {
        System.out.println("Calling car travel strategy");
    }
}
