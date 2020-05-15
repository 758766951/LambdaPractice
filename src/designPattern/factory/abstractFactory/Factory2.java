package designPattern.factory.abstractFactory;

public class Factory2 implements AbstractFactory{
    public  ProductA factoryA(){
        return new ProductA2();
    }
    public  ProductB factoryB(){

        return new ProductB2();
    }
}
