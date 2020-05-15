package designPattern.decorator;

//HouseBlend，具体饮料类，具体组件
public class HouseBlend extends Beverage {
    public  HouseBlend(){
        description = "HouseBlend";
    }
    public double cost(){
        return .99;
    }
}