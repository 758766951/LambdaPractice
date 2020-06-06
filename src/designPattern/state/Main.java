package designPattern.state;



/**
 *例子：万能糖果机，糖果有很多状态以及触发状态间的转换的动作
 * 考虑1：使用多个if else处理转换逻辑，修改代码必须从头开始理清逻辑，破坏开闭原则
 * 考虑2：状态模式。将每个状态的行为封装在各自的类中，将糖果机委托给代表当前状态的状态对象。
 * 添加玩游戏功能，使得有百分之十的机会投币一次获得两颗糖果
 */
public class Main {
    public static void main(String[] args){
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        gumballMachine.insertQuater();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);

        gumballMachine.insertQuater();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);

        gumballMachine.insertQuater();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine.toString());

    }
}
