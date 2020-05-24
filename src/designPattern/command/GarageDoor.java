package designPattern.command;

public class GarageDoor {
    private String name;

    public GarageDoor(){}
    public GarageDoor(String name){
        this.name  = name;
    }

    public void up(){
        System.out.println(name + " Garage Door is up.");
    }
    public void down(){
        System.out.println(name + " Garage Door is down.");
    }
    public void  stop(){
        System.out.println("Garage Door is stop.");
    }
    public void lightOn(){
        System.out.println("Garage Door is lightOn.");
    }
    public void lightOff(){
        System.out.println("Garage Door is lightOff.");
    }
}
