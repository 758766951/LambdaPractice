package designPattern.command;

public class GarageDoorUpCommand implements Command {
    private GarageDoor garageDoor;
    public GarageDoorUpCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }
    public void execute(){
        garageDoor.up();
    }
    public void undo(){
        garageDoor.down();
    }
}
