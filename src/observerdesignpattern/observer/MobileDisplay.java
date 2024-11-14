package observerdesignpattern.observer;

import observerdesignpattern.observable.WeatherStation;

public class MobileDisplay implements Display{

    private WeatherStation weatherStation;

    public MobileDisplay (WeatherStation weatherStation){
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        System.out.println("Temperature is exceeding: " + weatherStation.getData());
    }
}
