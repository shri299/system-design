package strategydesignpattern.driving;

public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new SpecialDrive());
    }
}
