package designPattern.factory.factoryMethod;

public class ConcreteProductA implements Product{
    /**
     * 假设生产的都是农作物
     */
    public ConcreteProductA(){
        System.out.println("生产ConcreteProductA");
    }
    /**
     * 种植
     */
    public void plant(){
        System.out.println("ConcreteProductA has been planted");
    }
    /**
     * 生长
     */
    public void grow(){
        System.out.println("ConcreteProductA is planting");
    }
    /**
     * 收获
     */
    public void harvest(){
        System.out.println("ConcreteProductA has been harvested");
    }

}
