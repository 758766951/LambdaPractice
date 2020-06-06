package designPattern.state;

public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }


    @Override
    public void insertQuater() {
        System.out.println("Please wait ,we're already giving you a gumball");
    }

    @Override
    public void ejectQuater() {
        System.out.println("Sorry,you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice dosen't you another gumball");
    }

    @Override
    public void dispense() {
        gumballMachine.realeseBall();
        if (gumballMachine.getCount()>0){
            gumballMachine.setState(gumballMachine.getNoQuaterState());
        }else{
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
