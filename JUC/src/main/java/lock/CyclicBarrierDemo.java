package lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        Order order = new Order();
        // 我有点弄不清楚AQS的原理，主要现在时间不多，我想先把整个JUC不懂的地方整理下
        // CyclicBarrier使用起来的感受：
        // 调用了 n 个的 await()才会执行这行命令
        CyclicBarrier cb = new CyclicBarrier(200,()->{order.confrimOrder();});

        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                order.pushOrder();
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"pushOrder").start();

        }

        for(int i=0; i<100;i++){
            new Thread(()->{
                order.searchLib();
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"searchLib").start();

        }

    }
}
