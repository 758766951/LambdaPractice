package designPattern.strategy;

public class FlyRocketPowered implements FlyBehavior {
    public void fly(){
        System.out.println("我正在搭载火箭飞行");
    }
}
