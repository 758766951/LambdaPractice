package designPattern.compound;


/**
 *例子：
 * 1、创建一群呱呱叫的鸭子类
 * 创建Quackable接口，某些鸭子（RedheadDuck、MallardDuck）实现了Quackable接口。
 * 2、当鸭子出现在这里时，鹅也应该在附近，如果我们想要在所有使用鸭子的地方使用鹅，就需要适配器模式。
 * 创建Goose类，创建GooseAdapter类实现Quackable接口，并持有Goose的引用，在所有需要呱呱叫的地方调用鹅来代替。
 * 3、添加统计呱呱叫的次数的需求，要求不变化鸭子类，装饰者模式。
 * 创建QuackCounter类实现Quackable接口，并持有Quackable的引用,当鸭子呱呱叫时就将其委托给装饰类对象。
 * 4、上一步中的装饰类包装的是对象，只有被包装的鸭子才能叫声计数，现在采用抽象工厂来改进，创建装饰过的鸭子，确保获取的鸭子一定是被装饰过的，一定可以计数。
 * 创建AbstrctDuckFactory类，创建DuckFactory类继承抽象类，创建出未被包装过的鸭子。创建CountingDuckFactory继承抽象类，创建出被包装过的鸭子。
 * 5、因为鸭子太多了，可以用组合模式统一管理，用迭代器模式查看内部对象。
 * 创建Flock类实现Quackable接口，并使用ArrayList集合类保存鸭子，循环遍历，调用呱呱叫。
 */
public class Main {
    public static void main(String[] args){
        /**
         * 测试1：模拟鸭子叫声
         */
//        simulate(new MallardDuck());
//        simulate(new RedheadDuck());

        /**
         * 测试2：使用鹅“冒充”鸭子发声
         */
//        Quackable gooseDuck = new GooseAdapter(new Goose());
//        simulate(gooseDuck);

        /**
         * 测试3：统计呱呱叫次数
         */
//        Quackable mallardDuck = new QuackCounter(new MallardDuck());
//        simulate(mallardDuck);
//        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
//        simulate(redheadDuck);
//        System.out.println(QuackCounter.getQuacks());

        /**
         * 测试4：使用抽象工厂创建鸭子
         */
//        AbstrctDuckFactory abstrctDuckFactory = new CountingDuckFactory();
//        Quackable mallardDuck = abstrctDuckFactory.createMallardDuck();
//        Quackable redheadDuck = abstrctDuckFactory.createRedheadDuck();
//        simulate(mallardDuck);
//        simulate(redheadDuck);
//        System.out.println(QuackCounter.getQuacks());

        /**
         * 测试5：管理一群鸭子
         */
        AbstrctDuckFactory abstrctDuckFactory = new CountingDuckFactory();
        Quackable mallardDuck1 = abstrctDuckFactory.createMallardDuck();
        Quackable mallardDuck2 = abstrctDuckFactory.createMallardDuck();
        Quackable mallardDuck3 = abstrctDuckFactory.createMallardDuck();
        Quackable redheadDuck = abstrctDuckFactory.createRedheadDuck();

        Flock flock = new Flock();
        flock.add(mallardDuck1);
        flock.add(mallardDuck2);
        flock.add(mallardDuck3);
        flock.add(redheadDuck);
        simulate(flock);
        System.out.println(QuackCounter.getQuacks());



    }


    private static void simulate(Quackable duck){
        duck.quack();
    }
}
