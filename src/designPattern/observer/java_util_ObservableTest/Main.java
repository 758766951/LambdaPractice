package designPattern.observer.java_util_ObservableTest;


import java.util.Observable;

public class Main {
    public static void main(String[] args){
        /**
         * 测试2：使用java内置的观察者模式
         * 我们不再需要追踪观察者了，也不需要管理注册与删除（让Observable超类代劳即可）
         * Current conditions: 80.0F degrees and 65.0%humidity
         * Current conditions: 75.0F degrees and 68.0%humidity
         * Current conditions: 70.0F degrees and 69.0%humidity
         */
        Observable observable = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(observable);
        ((WeatherData) observable).setMeasurements(80,65,30.4f);
        ((WeatherData) observable).setMeasurements(75,68,32.4f);
        ((WeatherData) observable).setMeasurements(70,69,30.5f);

    }
}
