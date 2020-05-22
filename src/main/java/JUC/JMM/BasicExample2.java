package JUC.JMM;

import java.util.concurrent.TimeUnit;

/**
 * 我希望下面的讨论都是沿着这个例子展开！
 * 这个例子着重描述的是原子性的作用。
 */
public class BasicExample2 {
    public volatile static int i = 0;

    public void add() {
        i++;
    }


    public static void main(String[] args) throws InterruptedException {
        BasicExample2 ex = new BasicExample2();

        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                ex.add();
            }
        }, "t1").start();

        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                ex.add();
            }
        }, "t2").start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println(ex.i);

    }
}
