package statedesignpattern.template;

public class Context {

    private State state;

    public Context (){
        state = new StateA();
    }

    public void setState(State state){
        this.state=state;
    }

    public void handle(){
        state.handle(this);
    }
}
