package designPattern.proxy.dynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * （1）创建一个接口，创建一个被代理类实现该接口（抽象角色和真实角色）
 * （2）定义一个类实现invocationHandle接口,并重写invoke（代理类，被代理的方法，方法的参数列表）方法。（代理角色）
 * （3）调用Proxy.newProxyInstance(类加载器，类实现的接口，事务处理器对象);生成一个代理实例。
 * （4）通过该代理实例调用方法。
 */
public class Main {
    public static void main(String[] args){
        ReadFile boss = new Boss();
        InvocationHandler handler = new Secretary(boss);
        //创建代理对象
        ReadFile secretary = (ReadFile) Proxy.newProxyInstance(
                boss.getClass().getClassLoader(),
                boss.getClass().getInterfaces(),
                handler);
        secretary.read();

    }
}
