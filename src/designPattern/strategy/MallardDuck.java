package designPattern.strategy;

//绿头鸭
public class MallardDuck extends Duck{
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    public  void display(){
        System.out.println("我是一只真正的绿头鸭");
    }
}
