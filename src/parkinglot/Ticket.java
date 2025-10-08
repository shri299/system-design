package parkinglot;

import java.time.LocalDateTime;
import java.util.Date;

public class Ticket {

    private String id;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Ticket (String id, Vehicle vehicle, ParkingSpot parkingSpot){
        this.id=id;
        this.vehicle=vehicle;
        this.parkingSpot=parkingSpot;
        this.entryTime= LocalDateTime.now();
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public ParkingSpot getParkingSport(){
        return this.parkingSpot;
    }
}
