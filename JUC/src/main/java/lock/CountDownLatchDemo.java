package lock;

import java.util.concurrent.*;


public class CountDownLatchDemo {

    public static void main(String[] args) {
        Order order = new Order();
        CountDownLatch countDownLatch = new CountDownLatch(98);

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,
                20,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        threadPool.execute(()->{
            try {
                // 一直等待 countDownLatch里面加少为0，才继续执行
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            order.confrimOrder();
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            threadPool.execute(()->{
                order.pushOrder();
                //
                countDownLatch.countDown();
            });
        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadPool.shutdown();






    }


}
