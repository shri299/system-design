package statedesignpattern.template;

public class StateA implements State {
    @Override
    public void handle(Context context) {
        System.out.println("Handling state a");
        context.setState(new StateB());
    }
}
