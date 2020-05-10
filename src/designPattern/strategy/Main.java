package designPattern.strategy;

import designPattern.strategy.Duck;
import designPattern.strategy.FlyRocketPowered;
import designPattern.strategy.MallardDuck;
import designPattern.strategy.ModelDuck;

/*例：游戏中有各种鸭子，一遍游戏戏水，一遍呱呱叫，现有的设计是设计了一个鸭子超类，并让各种鸭子继承此超类。
        现在有一个新需求，让鸭子会飞。
        考虑1：在超类中加上鸭子会飞的行为，然后让各种具体类继承，但其实并不是所有鸭子都会飞。
        考虑2：定义Flyable接口和Quackable接口，让会飞或者会叫的鸭子分别实现这两个接口，
        但接口不具有实现代码，实现接口造成代码复用，无论修改哪个行为，都需要往下追踪并在每一个实现此行为的类中修改它。
        考虑3：设计原则，找出应用中可能需要变化之处独立出来，不要和不需要变化的代码混合在一起。
        把鸭子的行为从Duck类中取出来，Duck类中的fly()和quack()会随着鸭子的不同而改变，建立一组新类来代表每个行为。*/
public class Main {
    public static void main(String[] args){
        /**
         * 测试1：实现鸭子飞行
         * 输出：实现鸭子呱呱叫\n我会飞行
         */
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        /**
         * 测试2：动态设定行为
         * 通过设定方法来设定鸭子的行为，而不是在构造器内部实例化、
         * 然后一只本来不会飞的鸭子具有飞行行为
         * 输出：我不会飞行\n我正在搭载火箭飞行
         */
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();


    }
}
