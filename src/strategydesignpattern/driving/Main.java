package strategydesignpattern.driving;

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle = new NormalVehicle();
        vehicle.driving();
        Vehicle vehicle1 = new SportVehicle();
        vehicle1.driving();
    }
}
