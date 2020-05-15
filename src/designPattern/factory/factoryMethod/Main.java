package designPattern.factory.factoryMethod;

//工厂方法是针对每一种产品提供一个工厂类。通过不同的工厂实例来创建不同的产品实例。
public class Main {
    public static void main(String[] args){
        Product pA = new ConcreteFactoryA().create();
        Product pB = new ConcreteFactoryB().create();
        pA.plant();
        pB.plant();
        /**
         * pA为何不能调用ConcreteFactoryA中的其他方法？
         * pA为何只能调用从Product中实现的方法，特有方法为何不能调用？
         * 只能通过强制转换后调用
         */
        ConcreteProductA cpA = (ConcreteProductA)pA;
        cpA.harvest();
        ConcreteProductA cp = new ConcreteProductA();
        cp.harvest();
    }
}
