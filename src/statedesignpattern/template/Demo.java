package statedesignpattern.template;

import statedesignpattern.template.Context;

public class Demo {

    public static void main(String[] args) {
        Context context = new Context();
        context.handle();
        context.handle();
    }
}
