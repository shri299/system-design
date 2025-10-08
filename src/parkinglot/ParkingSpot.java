package parkinglot;

public class ParkingSpot {

    private String id;
    private Vehicle vehicle;
    private boolean availability;
    private Type type;

    public ParkingSpot (String id, Type type){
        this.id=id;
        this.vehicle=null;
        this.availability=true;
        this.type=type;
    }

    public boolean isAvailability(){
        return  this.availability;
    }

    public Type getType(){
        return this.type;
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
        availability=false;
    }

    public void removeVehicle(){
        this.vehicle=null;
        availability=true;
    }

}
