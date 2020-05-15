package designPattern.factory.simpleFactory;

public class ConcreteProduct1 implements Product {
    /**
     * 种植
     */
    public void plant(){
        System.out.println("ConcreteProduct1 has been planted");
    }
    /**
     * 生长
     */
    public void grow(){
        System.out.println("ConcreteProduct1 is planting");
    }
    /**
     * 收获
     */
    public void harvest(){
        System.out.println("ConcreteProduct1 has been harvested");
    }
    /**
     * ConcreteProduct1特有方法
     */
    public void owner(){
        System.out.println("ConcreteProduct1特有方法");
    }
}
