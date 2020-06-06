package designPattern.state;

public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }


    @Override
    public void insertQuater() {
        System.out.println("the machine is sold out");
    }

    @Override
    public void ejectQuater() {
        System.out.println("the machine is sold out");
    }

    @Override
    public void turnCrank() {
        System.out.println("the machine is sold out");
    }

    @Override
    public void dispense() {
        System.out.println("the machine is sold out");
    }
}
