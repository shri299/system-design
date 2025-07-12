package strategydesignpattern.travelrouteplanner;

public class PublicTravelStrategy implements TravelStrategy{
    @Override
    public void calcTimeCost(int distance) {
        System.out.println("Calling public transport travel strategy");
    }
}
