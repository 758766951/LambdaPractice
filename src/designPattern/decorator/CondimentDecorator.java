package designPattern.decorator;

//调料类，也就是装饰者类
//继承Beverage拥有相同的类型，以便能够取代Beverage
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
