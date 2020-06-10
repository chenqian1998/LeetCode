import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
怎么和面试官沟通？？==》 可以先从main方法要展示什么东西开始，然后把接口有哪些？？？

 */

public class ProducerComsumer {
    BlockingQueue<String> blockingQueue = null;

    // 模拟产品
    AtomicInteger id = new AtomicInteger(1);
    public final String product_base = "手机";

    public ProducerComsumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void produce() {
        String product = product_base + id.getAndIncrement();
        Boolean res = false;
        try {
            res = blockingQueue.offer(product, 2, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (res) {
            System.out.println("生产：" + product + " 成功");
        } else {
            System.out.println("队列以满生产失败");
        }

    }

    public void consume() {

    }

    public static void main(String[] args) {
        ProducerComsumer pc = new ProducerComsumer(new ArrayBlockingQueue(3));
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                pc.produce();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                pc.consume();
            }
        }).start();
    }

}
