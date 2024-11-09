package strategydesignpattern;

public class Vehicle {

    private DriveInterface driveInterface;

    public Vehicle (DriveInterface driveInterface){
        this.driveInterface=driveInterface;
    }

    public void driving(){
        this.driveInterface.drive();
    }
}
