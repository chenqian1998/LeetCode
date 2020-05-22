package 场景题.JUC;

/**
 * 单例模式的核心是，只能new一次对象，如果
 */
public class Singleton {
    private volatile static Singleton instance = null;

    private Singleton() {
    }

    public Singleton getInstance() {
        // 可能两个线程在这里都判断instance为null，第一次检验
        if (instance == null) {
            // 锁住的是整个类的模版
            synchronized (Singleton.class) {
                // 因为上面可能有多个线程进来，但是synchronize限制了只有一个进程执行完，下一个才能进行
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

class lazySingleton {
    private volatile static lazySingleton instance = null;

    private lazySingleton() {
    }

    // 懒汉加载模式，为啥这个synchronized是加在方法上的，要锁住这个类的模版
    // 主要的问题就是每次期望获取对象的就要加锁，效率很低，双重校验就优化了这个问题
    public synchronized lazySingleton getInstance() {
        if (instance == null) {
            instance = new lazySingleton();
        }
        return instance;
    }
}

class HungrySingleton {
    private volatile static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public HungrySingleton getInstance() {
        return instance;
    }

}