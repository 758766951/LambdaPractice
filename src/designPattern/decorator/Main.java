package designPattern.decorator;


/*例子：星巴兹咖啡更新订单系统，以合乎他们的饮料供应需求
原先的设计：一个抽象类Beverage中有一个用于描述饮料名称的类变量description，一个抽象方法cost()计算饮料价格。很多不同饮料的实现类继承这个抽象类重写cost()方法。
新需求：购买咖啡时加入各种调料，如豆浆，红豆、珍珠，加入不同的调料收费不同。
考虑1：各种搭配（如红豆牛奶、珍珠奶茶等）添加各种类继承自抽象类Beverage，这样会类爆炸，且如果只要有顾客有新的搭配，又需要新的类。
考虑2：在抽象类Beverage中加入各种调料的类变量，且cost将计算所有调料的价钱，子类仍然重写，但会调用超类获取需要的调料价格，但一旦有新调料出现或者价格修改都需要更改抽象类，违反开放-关闭原则。
考虑3：装饰者模式，以饮料为主题，运行时以调料来“装饰”饮料*/
public class Main {
    public static void main(String[] args){
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+"$"+beverage.cost());//Espresso$1.99

        Beverage beverage2= new HouseBlend();
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()+"$"+beverage2.cost());
        //        HouseBlend,Soy,Mocha,Whip$1.5899999999999999


    }
}
