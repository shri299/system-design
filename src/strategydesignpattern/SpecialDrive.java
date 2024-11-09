package strategydesignpattern;

public class SpecialDrive implements DriveInterface{
    @Override
    public void drive() {
        System.out.println("This is special drive");
    }
}
