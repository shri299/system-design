package strategydesignpattern;

public class NormalDrive implements DriveInterface{
    @Override
    public void drive() {
        System.out.println("This is normal drive");
    }
}
