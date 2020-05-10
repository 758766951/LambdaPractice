package designPattern.observer.java_util_ObservableTest;


import java.util.Observable;

//我们不再需要追踪观察者了，也不需要管理注册与删除（让Observable超类代劳即可）
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    //构造器不再需要为记住观察者而建立list数据结构了
    public WeatherData(){}

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measureChanged();
    }

    public void measureChanged(){
//        在调用notifyObservers()之前，调用setChanged()来指示状态已改变
        setChanged();
//        我们没有调用notifyObservers()传送数据对象，这表示我们采取的是“拉的做法”
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
