package designPattern.decorator;

//浓缩咖啡，具体饮料类，具体组件
public class Espresso extends Beverage {
    public  Espresso(){
        description = "Espresso";
    }
    public double cost(){
        return 1.99;
    }
}
