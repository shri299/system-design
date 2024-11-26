package bridgedesignpattern;

public class Main {

    public static void main(String[] args) {
        LivingThing livingThing = new Bird(new MammalBreathing());
        livingThing.breatheMethod();

        LivingThing livingThing1 = new Bird(new AnimalBreathing());
        livingThing1.breatheMethod();
    }
}
