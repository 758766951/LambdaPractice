package designPattern.factory.simpleFactory;

public class ConcreteProduct2 implements Product{
    /**
     * 种植
     */
    public void plant(){
        System.out.println("ConcreteProduct2 has been planted");
    }
    /**
     * 生长
     */
    public void grow(){
        System.out.println("ConcreteProduct2 is planting");
    }
    /**
     * 收获
     */
    public void harvest(){
        System.out.println("ConcreteProduct2 has been harvested");
    }
    /**
     * ConcreteProduct2特有方法
     */
    public void owner(){
        System.out.println("ConcreteProduct2特有方法");
    }
}
