package designPattern.factory.simpleFactory;

//简单工厂设计又叫静态工厂方法模式，它定义了一个具体的工厂类负责创建一些类的实例，接受了一个参数，通过不同的参数实例化不同的产品类。
public class Main {
    public static void main(String[] args ){
        try {
            Product p1= SimpleFactory.factory("ConcreteProduct1");
            Product p2= SimpleFactory.factory("ConcreteProduct2");
            Product p3= SimpleFactory.factory("ConcreteProduct3");
//            Product p4= SimpleFactory.factory("rtyui");
            p1.grow();
            p2.grow();
            p3.grow();
//            p4.grow();
        }
        catch (seedException e) {
            e.printStackTrace();
        }
    }
}
