package parkinglot;

import parkinglot.fees.TimeBased;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        //create parking spots
        ParkingSpot ps1 = new ParkingSpot("1",Type.CAR);
        ParkingSpot ps2 = new ParkingSpot("2",Type.BIKE);
        ParkingSpot ps3 = new ParkingSpot("3",Type.TRUCK);

        //create parking floors
        ParkingFloor pf1 = new ParkingFloor("1",new ArrayList<>(Arrays.asList(ps1,ps2)));
        ParkingFloor pf2 = new ParkingFloor("2",new ArrayList<>(Arrays.asList(ps3)));

        //creating vehicle
        Vehicle v1 = new Vehicle("1wer34",Type.CAR);

        //create object of parking lot to initiate flow
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addFloor(pf1);
        parkingLot.addFloor(pf2);
        parkingLot.setFeeStrategy(new TimeBased());
        //park the vehicle
        try {
            Ticket ticket = parkingLot.park(v1);
        }catch (Exception e){
            System.out.println("Something went wrong");
        }

        //un park the vehicle
    }
}
