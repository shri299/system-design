package observerdesignpattern.observable;

import observerdesignpattern.observer.Display;

import java.util.List;

public class WeatherStationImpl implements WeatherStation{

    List<Display> subscribers;
    private int temperature;
    @Override
    public void add(Display display) {
        subscribers.add(display);
    }

    @Override
    public void remove(Display display) {
        subscribers.remove(display);
    }

    @Override
    public void notifySubscriber() {
        for (Display display: subscribers){
            display.update();
        }
    }

    @Override
    public void setData(int data) {
        temperature = data;
        if (temperature>100){
            notifySubscriber();
        }
    }

    @Override
    public int getData() {
        return temperature;
    }
}
