package designPattern.templateMethod;

public abstract class CaffeineBeverage {
    public void prepareRecipe(){
        boilerWater();
        pounchCup();
        brew();
        addCondiments();
    }
    public void boilerWater(){
        System.out.println("将水煮沸");
    }
    public abstract void pounchCup();
    public void brew(){
        System.out.println("将饮料倒入杯中");
    }
    public abstract void addCondiments();
}
