package designPattern.observer.javaUtilObservableTest;


import designPattern.observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

//目前状况布告板
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Observable observable;

    //此布告板需要主题对象weatherData，作为注册之用
    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    public void update(Observable obs,Object arg){
        if(obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData)obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
    public void display(){
        System.out.println("Current conditions: "+temperature
        +"F degrees and " + humidity + "%humidity");
    }
}
