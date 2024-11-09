package strategydesignpattern;

public class NormalVehicle extends Vehicle{
    public NormalVehicle() {
        super(new NormalDrive());
    }
}
