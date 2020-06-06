package designPattern.state;

public class GumballMachine {
    private State soldOutState;
    private State noQuaterState;
    private State hasQuaterState;
    private State soldState;
    private State winnerState;

    private State state = soldOutState;
    private int count = 0;//记录剩余糖果数量

    public GumballMachine( int count) {
        this.soldOutState = new SoldOutState(this);
        this.noQuaterState = new NoQuaterState(this);
        this.hasQuaterState = new HasQuaterState(this);
        this.soldState = new SoldState(this);
        this.winnerState = new WinnerState(this);
        this.count = count;
        if (count>0){
            state = noQuaterState;
        }
    }

    public void insertQuater() {
        state.insertQuater();
    }

    public void ejectQuater() {
        state.ejectQuater();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void realeseBall(){
        System.out.println("A gumball comes rolling out the slot...");
        if(count != 0){
            count = count - 1;
        }
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }

    public State getNoQuaterState() {
        return noQuaterState;
    }

    public void setNoQuaterState(State noQuaterState) {
        this.noQuaterState = noQuaterState;
    }

    public State getHasQuaterState() {
        return hasQuaterState;
    }

    public void setHasQuaterState(State hasQuaterState) {
        this.hasQuaterState = hasQuaterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public void setWinnerState(State winnerState) {
        this.winnerState = winnerState;
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
