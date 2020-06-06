package designPattern.proxy.cglib;


import designPattern.proxy.dynamicProxy.Boss;

/**
 *例子：cglib动态代理
 *
 */
public class Main {
    public static void main(String[] args){
        BossProxy bossProxy = new BossProxy();
        Boss boss = (Boss)bossProxy.getInstance(new Boss());
        boss.read();
    }
}
