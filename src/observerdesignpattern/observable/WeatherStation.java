package observerdesignpattern.observable;

import observerdesignpattern.observer.Display;

public interface WeatherStation {

    public void add(Display display);

    public void remove(Display display);

    public void notifySubscriber();

    public void setData(int data);

    public int getData();
}
