public class Singleton {
    private volatile static Singleton instance = null;

    private Singleton(){}

    public Singleton getInstance(){
        // 先判断一次当前是不是null，可以减少锁的次数
        if (instance == null){
            synchronized (Singleton.class){
                //在创建的时候再判断一次
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
