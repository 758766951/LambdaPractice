package designPattern.compound;

public class GooseAdapter  implements Quackable {

    Goose goose;

    public GooseAdapter(Goose goose){
        this.goose = goose;
//        observable = new Observable(this);
    }

    @Override
    public void quack() {
        goose.hoke();
//        notifyObservers();
    }


}
