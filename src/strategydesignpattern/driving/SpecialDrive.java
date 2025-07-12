package strategydesignpattern.driving;

import strategydesignpattern.driving.DriveInterface;

public class SpecialDrive implements DriveInterface {
    @Override
    public void drive() {
        System.out.println("This is special drive");
    }
}
