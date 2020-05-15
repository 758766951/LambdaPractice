package designPattern.factory.abstractFactory;

//抽象工厂提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类。
//可以将工厂方法看做特殊的抽象工厂，也就是每个工厂实例只生产一种产品，而抽象工厂的每个工厂实例需要生产一族产品
public class Main {
    public static void main(String[] args){
        ProductA pA1 = new Factory1().factoryA();
        ProductB pB1 = new Factory1().factoryB();
        ProductA pA2 = new Factory2().factoryA();
        ProductB pB2 = new Factory2().factoryB();
        pA1.plantBC();
        pB1.plantBM();
        pA2.plantBC();
        pB2.plantBM();

    }
}
