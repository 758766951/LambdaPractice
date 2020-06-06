package designPattern.state;

public class NoQuaterState implements State {
    GumballMachine gumballMachine;

    public NoQuaterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuater() {
        System.out.println("You inserted a quater");
        gumballMachine.setState(gumballMachine.getHasQuaterState());
    }

    @Override
    public void ejectQuater() {
        System.out.println("You haven't inserted a quater");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned,but there's no quater");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }
}
