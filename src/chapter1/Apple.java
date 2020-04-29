package chapter1;


public class Apple {
    int weight;
    String color;
    boolean isRipe;

    public Apple(){    }
    public Apple(int weight){ this.weight=weight;   }

    public Apple(int weight, String color){
        this.weight=weight;
        this.color=color;
    }
    public Apple(int weight, String color,boolean isRipe){
        this.weight=weight;
        this.color=color;
        this.isRipe = isRipe;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public boolean isRipe() {
        return isRipe;
    }

    public void setRipe(boolean ripe) {
        isRipe = ripe;
    }
    public String toString(){
        return getColor()+"--"+getWeight()+"--"+isRipe();
    }

}
