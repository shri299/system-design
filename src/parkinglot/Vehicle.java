package parkinglot;

public class Vehicle {

    private String licenceNumber;
    private Type type;

    public Vehicle (String licenceNumber, Type type){
        this.licenceNumber=licenceNumber;
        this.type = type;
    }

    public Type getVehicleType(){
        return this.type;
    }
}
