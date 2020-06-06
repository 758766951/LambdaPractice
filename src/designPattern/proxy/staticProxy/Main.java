package designPattern.proxy.staticProxy;


 

/**
 *例子：经纪人代理明星签合同
 */
public class Main {
    public static void main(String[] args){
       People people = new Star();
       ManagerProxy managerProxy = new ManagerProxy(people);
       managerProxy.sign();

    }
}
