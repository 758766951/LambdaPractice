package designPattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Secretary类，不是代理类，但利用这个类能创建出代理类
 * Secretary类中有一个变量object用来存boss对象，因为接下来Secretary要代理Boss做的事，因此先要把boss对象先保存起来。
 * Secretary类如果想代理Boss做的事，即调用Boss类的方法，必须实现InvocationHandler，重载invoke方法，然后在invoke函数中调用Boss类的方法。
 * invoke函数中有一句method.invoke(object, args)，代理类就是用这种方式调用委托类的方法。
 *
 */
public class Secretary  implements InvocationHandler {
    private Object object;
    public Secretary(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("I'm secretary.");
        Object result = method.invoke(object, args);
        return result;
    }

}
