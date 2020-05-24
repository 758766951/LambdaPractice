package designPattern.command;

//NoCommand是一个空对象
// 在RemoteControl构造器中，将每个插槽都预先指定NoCommand对象，
//这样做的好处是，不用每次调用execute方法之前都要判断对象是不是空
public class NoCommand implements Command {
    public void execute(){

    }
    public void undo(){

    }
}
