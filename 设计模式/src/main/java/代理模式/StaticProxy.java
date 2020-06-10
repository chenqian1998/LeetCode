package 代理模式;


/*
记忆面包叮当（1）
静态代理：就是我一直理解的动态代理的方法，一个代理类Proxy，持有一个原对象，然后再原对象方法执行之前，会执行其他方法
静态代理的问题就是如果这个代理类要
 */

interface ManToolsFactory {
    void saleManTools(int size);
}

class ConcreteFactory implements ManToolsFactory {

    @Override
    public void saleManTools(int size) {
        System.out.println("订购一个大小 ：" + size + " 的女模特");
    }
}

interface WomanToolsFactory {
    void saleWoManTools(int length);
}

class ConcreteBFactory implements WomanToolsFactory {

    @Override
    public void saleWoManTools(int length) {
        System.out.println("订购一个大小 ：" + length + " 的男模特");
    }
}

class myProxy implements ManToolsFactory {
    ManToolsFactory mFactory;

    public myProxy(ManToolsFactory mFactory) {
        this.mFactory = mFactory;
    }

    @Override
    public void saleManTools(int size) {
        Before();
        mFactory.saleManTools(size);
        After();
    }

    public void Before() {
        System.out.println("...前置操作...");
    }

    public void After() {
        System.out.println("...前置操作...");
    }
}


public class StaticProxy {
    public static void main(String[] args) {
        myProxy proxy = new myProxy(new ConcreteFactory());
        proxy.saleManTools(10);
    }
}
