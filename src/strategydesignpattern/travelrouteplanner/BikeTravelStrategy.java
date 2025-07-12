package strategydesignpattern.travelrouteplanner;

public class BikeTravelStrategy implements TravelStrategy{
    @Override
    public void calcTimeCost(int distance) {
        System.out.println("Calling bike travel strategy");
    }
}
