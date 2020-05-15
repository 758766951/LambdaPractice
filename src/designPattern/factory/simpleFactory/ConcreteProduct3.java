package designPattern.factory.simpleFactory;

public class ConcreteProduct3 implements Product{
    /**
     * 种植
     */
    public void plant(){
        System.out.println("ConcreteProduct3 has been planted");
    }
    /**
     * 生长
     */
    public void grow(){
        System.out.println("ConcreteProduct3 is planting");
    }
    /**
     * 收获
     */
    public void harvest(){
        System.out.println("ConcreteProduct3 has been harvested");
    }
    /**
     * ConcreteProduct3特有方法
     */
    public void owner(){
        System.out.println("ConcreteProduct3特有方法");
    }
}
