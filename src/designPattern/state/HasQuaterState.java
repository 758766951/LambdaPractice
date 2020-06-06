package designPattern.state;

import java.util.Random;

public class HasQuaterState implements State {
    Random randomWinner = new Random(System.currentTimeMillis());
    GumballMachine gumballMachine;

    public HasQuaterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuater() {
        System.out.println("You can't insert another quater");
    }

    @Override
    public void ejectQuater() {
        System.out.println("Quater returned");
        gumballMachine.setState(gumballMachine.getNoQuaterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = randomWinner.nextInt(10);
        if((winner==0) && gumballMachine.getCount()>1){
            gumballMachine.setState(gumballMachine.getWinnerState());
        }else{
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispense");
    }
}
