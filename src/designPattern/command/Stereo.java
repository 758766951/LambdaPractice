package designPattern.command;

public class Stereo {
    private String name;
    private int volume;

    public Stereo(){}
    public Stereo(String name){
        this.name  = name;
    }


    public void setCD() {
        System.out.println(name+" Stereo is playing with CD.");
    }

    public void on(){
        System.out.println(name + " Stereo is on.");
    }

    public void off(){
        System.out.println(name + " Stereo is off.");
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }



}
