package bridgedesignpattern;

public abstract class LivingThing {

    private Breathing breathing;

    public LivingThing (Breathing breathing){
        this.breathing=breathing;
    }

    public void breatheMethod(){
        breathing.breathingMethod();
    }
}
