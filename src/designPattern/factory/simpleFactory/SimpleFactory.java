package designPattern.factory.simpleFactory;

public class SimpleFactory {
    /**
     * 静态工厂方法
     */
    public static Product factory(String seed)
    throws seedException{
        if(seed.equals("ConcreteProduct1")){
            return new ConcreteProduct1();
        }
        else if(seed.equals("ConcreteProduct2")){
            return new ConcreteProduct2();
        }
        else if(seed.equals("ConcreteProduct3")){
            return new ConcreteProduct3();
        }
        else{
            throw new seedException("无法生产此种产品");
        }
    }
}
