package observerdesignpattern.observer;

import observerdesignpattern.observable.WeatherStation;

public class TelevisionDisplay implements Display{

    private WeatherStation weatherStation;

    public TelevisionDisplay (WeatherStation weatherStation){
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        System.out.println("Temperature is exceeding: " + weatherStation.getData());
    }
}
