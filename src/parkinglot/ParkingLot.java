package parkinglot;

import parkinglot.fees.Fee;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<ParkingFloor> floors = new ArrayList<>();

    private Fee fee;

    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }

    public void setFeeStrategy(Fee fee){
        this.fee=fee;
    }

    public Ticket park(Vehicle vehicle){
        for (ParkingFloor floor : floors){
            ParkingSpot ps = floor.getAvailableSpots(vehicle.getVehicleType());
            if (ps!=null){
                ps.addVehicle(vehicle);
                return new Ticket("t1",vehicle,ps);
            }
        }
        throw new RuntimeException("No available spots");
    }

    public Double unPark(Ticket ticket){
        Vehicle vehicle = ticket.getVehicle();
        ParkingSpot spot = ticket.getParkingSport();
        Double fees = fee.calcFee();
        spot.removeVehicle();
        return fees;
    }
}
