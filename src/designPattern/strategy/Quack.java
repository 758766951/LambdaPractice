package designPattern.strategy;

public class Quack implements QuackBehavior {
    public void quack(){
        System.out.println("实现鸭子呱呱叫");
    }
}
