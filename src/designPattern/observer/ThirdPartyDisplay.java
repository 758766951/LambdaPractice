package designPattern.observer;

public class ThirdPartyDisplay implements  Observer,DisplayElement{
    public void update(float temperature,float humidity,float pressure){

    }
    public void display(){
        //显示基于观测值的其他内容
    }
}
