package designPattern.observer;

//目前状况布告板
public class CurrentConditionsDisplay implements  Observer,DisplayElement{
    private float temperature;
    private float humidity;
    private Subject weatherData;

    //此布告板需要主题对象weatherData，作为注册之用
    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
    public void display(){
        System.out.println("Current conditions: "+temperature
        +"F degrees and " + humidity + "%humidity");
    }
}
