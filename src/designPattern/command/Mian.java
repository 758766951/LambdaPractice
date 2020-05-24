package designPattern.command;

/**
 * 例子：设计一个家电自动化遥控器的API， 一个遥控器可以管控家里所有家电。
 * 考虑1：传统的面向对象设计，switch case，扩展不便，添加按钮时修改内部代码
 * 考虑2：命令模式
 * 简单的设计1：Command接口，含执行动作抽象方法execute()
 *              LightOnCommand类实现Command接口，内含Light类引用实现具体的execute()动作
 *              LightOffCommand类、GarageDoorCommand类实现Command接口
 *              Light类，GarageDoor类，内含具体动作
 *              SimpleRemoteControl类，内含Command引用，设置Command方法setCommand(Command command)、buttonWasPressed()执行Command动作
 * 设计2：RemoteControl类，内含Command数组，操控7个开关按钮
 *        LightOffCommand类实现Command接口
 *        StereoOnWithCDCommand(Stereo stereo)
 *        Stereo类内含具体动作
 *        NoCommand类实现Command接口,是一个空对象, 在RemoteControl构造器中，将每个插槽都预先指定NoCommand对象，这样做的好处是，不用每次调用execute方法之前都要判断对象是不是空
 * 设计3：Command接口，添加撤销动作抽象方法undo()
 *        RemoteControlWithUndo类，类似于 RemoteControl类，内含Command数组，操控7个开关按钮，不同的是，添加undoButtonWasPressed()方法在其中执行具体对象的undo()方法
 */
public class Mian {
    public static void main(String[] args){
        /**
         * 测试1：SimpleRemoteControl简单遥控器测试
         *
         */
//        //测试点灯亮按钮
//        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
//        Light light = new Light();
//        LightOnCommand lightOnCommand = new LightOnCommand(light);
//        simpleRemoteControl.setCommand(lightOnCommand);
//        simpleRemoteControl.buttonWasPressed();//light is on.
//        //测试Garage门开着按钮
//        GarageDoor garageDoor = new GarageDoor();
//        GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(garageDoor);
//        simpleRemoteControl.setCommand(garageDoorUpCommand);
//        simpleRemoteControl.buttonWasPressed();//Garage Door is up.

        /**
         * 测试2：RemoteControl遥控器测试
         *
         */
//        RemoteControl remoteControl = new RemoteControl();
//
//        Light livingRoomLight = new Light("Living Room");
//        Light kitchenLight = new Light("kitchen");
//        GarageDoor garageDoor = new GarageDoor("");
//        Stereo stereo = new Stereo("Living Room");
//
//        LightOnCommand livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
//        LightOffCommand livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);
//        LightOnCommand kitchenLightOnCommand = new LightOnCommand(kitchenLight);
//        LightOffCommand kitchenLightOffCommand = new LightOffCommand(kitchenLight);
//
//        GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(garageDoor);
//        GarageDoorDownCommand garageDoorDownCommand = new GarageDoorDownCommand(garageDoor);
//
//        StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
//        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
//
//        remoteControl.setCommand(0,livingRoomLightOnCommand,livingRoomLightOffCommand);
//        remoteControl.setCommand(1,kitchenLightOnCommand,kitchenLightOffCommand);
//        remoteControl.setCommand(2,stereoOnWithCDCommand,stereoOffCommand);
//        remoteControl.setCommand(3,garageDoorUpCommand,garageDoorDownCommand);
//
//        System.out.println(remoteControl);//[slot 0]designPattern.command.LightOnCommand  designPattern.command.LightOffCommand[slot 1]designPattern.command.LightOnCommand  designPattern.command.LightOffCommand[slot 2]designPattern.command.StereoOnWithCDCommand  designPattern.command.StereoOffCommand[slot 3]designPattern.command.GarageDoorUpCommand  designPattern.command.GarageDoorDownCommand[slot 4]designPattern.command.NoCommand  designPattern.command.NoCommand[slot 5]designPattern.command.NoCommand  designPattern.command.NoCommand[slot 6]designPattern.command.NoCommand  designPattern.command.NoCommand
//        remoteControl.onButtonWasPushed(0);//Living Room light is on.
//        remoteControl.offButtonWasPushed(0);//Living Room light is off.
//        remoteControl.onButtonWasPushed(1);//kitchen light is on.
//        remoteControl.offButtonWasPushed(1);//kitchen light is off.
//        remoteControl.onButtonWasPushed(2);//Living Room Stereo is on. \n  Living Room Stereo is playing with CD.
//        remoteControl.offButtonWasPushed(2);//Living Room Stereo is off.
//        remoteControl.onButtonWasPushed(3);// Garage Door is up.
//        remoteControl.offButtonWasPushed(3);// Garage Door is down.


        /**
         * 测试3：RemoteControlWithUndo遥控器测试
         *
         */
        RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();
        Light livingRoomLight = new Light("Living Room");
        LightOnCommand livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);

        remoteControlWithUndo.setCommand(0,livingRoomLightOnCommand,livingRoomLightOffCommand);

        remoteControlWithUndo.onButtonWasPushed(0);//Living Room light is on.
        remoteControlWithUndo.offButtonWasPushed(0);//Living Room light is off.
        remoteControlWithUndo.undoButtonWasPressed();//Living Room light is on.
        remoteControlWithUndo.offButtonWasPushed(0);//Living Room light is off.
        remoteControlWithUndo.onButtonWasPushed(0);//Living Room light is on.
        System.out.println(remoteControlWithUndo);//[slot 0]designPattern.command.LightOnCommand  designPattern.command.LightOffCommand[slot 1]designPattern.command.NoCommand  designPattern.command.NoCommand[slot 2]designPattern.command.NoCommand  designPattern.command.NoCommand[slot 3]designPattern.command.NoCommand  designPattern.command.NoCommand[slot 4]designPattern.command.NoCommand  designPattern.command.NoCommand[slot 5]designPattern.command.NoCommand  designPattern.command.NoCommand[slot 6]designPattern.command.NoCommand  designPattern.command.NoCommand
        remoteControlWithUndo.undoButtonWasPressed();//Living Room light is off.
    }
}
