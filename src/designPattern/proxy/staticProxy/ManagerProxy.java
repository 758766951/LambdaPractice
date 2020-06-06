package designPattern.proxy.staticProxy;

public class ManagerProxy implements People{
    People people;

    public ManagerProxy(People people) {
        this.people = people;
    }


    public void sign() {
        System.out.println("我是经纪人");
        people.sign();
    }
}
