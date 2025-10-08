package parkinglot;

import java.util.List;

public class ParkingFloor {

    private String id;
    private List<ParkingSpot> parkingSpots;


    public ParkingFloor (String id, List<ParkingSpot> parkingSpots){
        this.id=id;
        this.parkingSpots=parkingSpots;
    }

    public ParkingSpot getAvailableSpots(Type type){
        for (ParkingSpot spot : parkingSpots){
            if (spot.isAvailability() && spot.getType().equals(type)){
                return spot;
            }
        }
        return null;
    }
}
