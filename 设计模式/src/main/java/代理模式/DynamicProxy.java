package 代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    /*
        InvocationHandler是用来定义 invoke() 具体的实现
     */

    /**
     * 被代理的类
     */
    Object factory;

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    public Object getFactory() {
        return factory;
    }


    /**
     * invoke方法就是定义了这个代理过程,增强类的方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object ret = method.invoke(factory, args);
        doAfter();
        return ret;
    }

    public Object getProxyInstance() {
        // Proxy.newProxyInstance定义了如何实现业务的功能
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(), this);
    }

    public void doBefore() {
        System.out.println("...前置操作...");
    }

    public void doAfter() {
        System.out.println("...前置操作...");
    }

    public static void main(String[] args) {
        ManToolsFactory factory = new ConcreteFactory();
        DynamicProxy proxy = new DynamicProxy();
        // 设置需要被代理的是哪个类
        proxy.setFactory(factory);
        //现获得一个代理类
        ManToolsFactory proxyInstance = (ManToolsFactory) proxy.getProxyInstance();
        // 代理类执行增强的方法
        proxyInstance.saleManTools(10);

        // 代理女性服务
        WomanToolsFactory wfactory = new ConcreteBFactory();
        proxy.setFactory(wfactory);
        WomanToolsFactory proxyInstance1 = (WomanToolsFactory) proxy.getProxyInstance();
        proxyInstance1.saleWoManTools(100);
    }
}
