package designPattern.factory.factoryMethod;

public class ConcreteProductB implements Product {

    public ConcreteProductB(){
        System.out.println("生产ConcreteProductB");
    }
    /**
     * 种植
     */
    public void plant(){
        System.out.println("ConcreteProductB has been planted");
    }

}
