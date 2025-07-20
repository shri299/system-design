package statedesignpattern.template;

import statedesignpattern.template.Context;

public interface State {

    void handle(Context context);
}
