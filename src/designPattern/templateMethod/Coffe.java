package designPattern.templateMethod;

public class Coffe extends CaffeineBeverage {
    public void pounchCup(){
        System.out.println("用沸水冲泡咖啡");
    }

    public void addCondiments(){
        System.out.println("加糖和奶");
    }
}
