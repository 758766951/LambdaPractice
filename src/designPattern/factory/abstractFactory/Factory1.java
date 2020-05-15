package designPattern.factory.abstractFactory;

public class Factory1 implements AbstractFactory{
    public  ProductA factoryA(){
        return new ProductA1();
    }
    public  ProductB factoryB(){
        return new ProductB1();
    }
}
