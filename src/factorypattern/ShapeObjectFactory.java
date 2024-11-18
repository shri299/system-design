package factorypattern;

public class ShapeObjectFactory {
    Shape getShape(String input){
        return switch (input) {
            case "circle" -> new Circle();
            case "rectangle" -> new Rectangle();
            default -> null;
        };
    }
}
