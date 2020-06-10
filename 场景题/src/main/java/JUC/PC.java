package JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 基于阻塞队列的PC问题
 */
class Product {
    int id;
    String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


class BasicPC {
    private BlockingQueue<Product> queue = null;
    private AtomicInteger goods_id = new AtomicInteger(0);
    private final String goods_name = "abc";


    public BasicPC(BlockingQueue<Product> queue) {
        this.queue = queue;
    }

    public void produce() {
        Product p = new Product(goods_id.getAndIncrement(), "abc");
        // 这个offer可以在指定时间内尝试加入，如果不能成功就会抛出异常
        // 为啥能够在指定时间内尝试
        // lock()是一直等待
        // trylock()是尝试获取，如果获取不到就立即返回False
        // lockInterruptibly()就是在规定时间内获取锁
        boolean res = false;
        try {
            res = queue.offer(p, 2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (res) {
            System.out.println("生产产品成功");
        } else {
            System.out.println("队列已满，插入失败");
        }
    }

    public void consume() {
        Product p = null;
        try {
            p = queue.poll(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (p == null) {
            System.out.println("队列为空");
        } else {
            System.out.println("消费产品成功： " + p);
        }

    }

}


public class PC {
    public static void main(String[] args) {
        BasicPC pc = new BasicPC(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            for(int i=0; i<100;i++){
                pc.produce();
            }
        },"produce").start();

        new Thread(() -> {
            for(int i=0; i<100;i++){
                pc.consume();
            }
        },"consume").start();
    }
}
