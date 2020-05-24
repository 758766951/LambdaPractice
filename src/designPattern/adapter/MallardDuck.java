package designPattern.adapter;


//绿头鸭
public class MallardDuck implements Duck{
    public void quack(){
        System.out.println("Quack");
    }
    public void fly(){
        System.out.println("I an flying");
    }
 }
