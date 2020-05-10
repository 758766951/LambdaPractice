package designPattern.strategy;

//模型鸭
public class ModelDuck extends Duck{
    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public  void display(){
        System.out.println("我是一只模型鸭");
    }
}
