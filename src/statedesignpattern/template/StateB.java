package statedesignpattern.template;


public class StateB implements State {
    @Override
    public void handle(Context context) {
        System.out.println("Handling state b");
    }
}
