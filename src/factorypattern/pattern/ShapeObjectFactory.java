package factorypattern.pattern;

import factorypattern.pattern.Circle;
import factorypattern.pattern.Rectangle;
import factorypattern.pattern.Shape;

public class ShapeObjectFactory {
    Shape getShape(String input){
        return switch (input) {
            case "circle" -> new Circle();
            case "rectangle" -> new Rectangle();
            default -> null;
        };
    }
}
