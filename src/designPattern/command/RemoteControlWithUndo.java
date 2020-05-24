package designPattern.command;

public class RemoteControlWithUndo {
    //遥控器处理7个开与关的命令
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControlWithUndo() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    //三个参数，插卡槽位置(按的第几个按钮)，开的命令，关的命令
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPressed(){
        undoCommand.undo();
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("\n--------Remote Control--------\n");
        for(int i=0;i<onCommands.length;i++){
            sb.append("[slot "+i+"]"+onCommands[i].getClass().getName()+"  "
                    +offCommands[i].getClass().getName());
        }
        return sb.toString();
    }
}
