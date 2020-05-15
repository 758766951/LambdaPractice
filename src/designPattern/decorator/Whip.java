package designPattern.decorator;
//具体装饰类
public class Whip extends CondimentDecorator {
    Beverage beverage;
    public Whip(Beverage beverage){
        this.beverage = beverage;
    }
    public String getDescription(){
        return beverage.getDescription()+",Whip";
    }
    public  double cost(){
        return .20+beverage.cost();
    }
}