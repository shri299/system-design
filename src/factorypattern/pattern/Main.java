package factorypattern.pattern;

public class Main {

    public static void main(String[] args) {
        ShapeObjectFactory objectFactory = new ShapeObjectFactory();
        Shape shape = objectFactory.getShape("ok");
        if (shape == null) {
            System.out.println("no valid shape");
        } else {
            shape.draw();
        }
    }
}
