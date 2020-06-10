package waitNotify;

import java.util.concurrent.TimeUnit;

public class waitnotifyDemo1 {
    static final Object obj = new Object();  //对象锁

    public static void main(String[] args) throws Exception {

        Thread consume = new Thread(new Consume(), "Consume");
        Thread produce = new Thread(new Produce(), "Produce");
        consume.start();
        Thread.sleep(1000);
        produce.start();
//
//        try {
//            produce.join();
//            consume.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    // 生产者线程
    static class Produce implements Runnable {

        @Override
        public void run() {

            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + "：开始生产！");
                try {
                    TimeUnit.MILLISECONDS.sleep(5000);  //模拟生产过程
                    obj.notify();  //只有生产完才通知消费者
                    System.out.println("结束生产");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费者线程
    static class Consume implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + ":准备消费");

                try {
                    obj.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("开始消费");
            }

        }
    }
}
