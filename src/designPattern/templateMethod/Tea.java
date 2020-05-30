package designPattern.templateMethod;

public class Tea extends CaffeineBeverage {
    public void pounchCup(){
        System.out.println("用沸水浸泡茶叶");
    }

    public void addCondiments(){
        System.out.println("加柠檬");
    }
}