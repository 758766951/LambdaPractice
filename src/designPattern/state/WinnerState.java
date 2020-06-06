package designPattern.state;

public class WinnerState implements State {
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
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
        System.out.println("YOU ARE A　WINER ! You get two gumballs");
        gumballMachine.realeseBall();
        if (gumballMachine.getCount()==0){
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }else{
            gumballMachine.realeseBall();
            if(gumballMachine.getCount()>0){
                gumballMachine.setState(gumballMachine.getNoQuaterState());
            }else{
                System.out.println("Oops, out of gumballs!");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
