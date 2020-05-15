package designPattern.factory.factoryMethod;

public class ConcreteFactoryB implements FactoryMethod {
    public Product create(){
        return new ConcreteProductB();
    }
}
