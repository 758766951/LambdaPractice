package designPattern.factory.factoryMethod;

public class ConcreteFactoryA implements FactoryMethod {
    public Product create(){
        return new ConcreteProductA();
    }
}
