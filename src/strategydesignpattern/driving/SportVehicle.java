package strategydesignpattern.driving;

public class SportVehicle extends Vehicle {
    public SportVehicle() {
        super(new SpecialDrive());
    }
}
