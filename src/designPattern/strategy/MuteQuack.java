package designPattern.strategy;

public class MuteQuack implements QuackBehavior {
    public void quack(){
        System.out.println("我不会叫");
    }
}
