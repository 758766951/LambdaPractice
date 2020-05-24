package designPattern.adapter;


 public class Main {
    public static void main(String[] args){
        /**
         * 测试：对象适配器，用火鸡“冒充”鸭子
         *   TurkeyAdapter类实现Duck，内含Turkey引用，用Turkey的gobble和fly实现(冒充)鸭子的quack和fly
         */

        Duck mallardDuck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();;
        turkey.fly();

        System.out.println("\nThe Duck says...");
        testDuck(mallardDuck);

        System.out.println("\nThe TurkeyAdapter says");
        testDuck(turkeyAdapter);
    }
    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
}
