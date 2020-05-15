package designPattern.decorator;

/**
 * 此时用的是抽象类而不是接口，一个原因是因为尽力避免更改之前的设计
 * 另一个原因此时虽然也是用的继承，但这么做的重点在于装饰者和被装饰者必须是一样的类型，也就是有共同的超类
 * 这里利用继承达到“类型匹配”，而不是继承获得“行为”
 */
//饮料类，抽象组件，被装饰类
public abstract class Beverage {
    String description = "Unkonow Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();



}
