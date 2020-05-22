package JUC.JMM;

import java.util.concurrent.TimeUnit;

/**
 * 这个例子主要就是说明volatile可见性的问题。
 */
public class BasicExample {
    private volatile static boolean flag = true;

    public void checking() {
        while (true) {
            if (!flag) {
                // 处理一些善后的工作
                break;
            }
            // 业务处理，记录。。
        }
    }

    public void stop() {
        flag = false;
    }

    public static void main(String[] args) throws InterruptedException {
        BasicExample ex = new BasicExample();

        Thread t = new Thread(() -> {
            ex.checking();
        }, "t1");
        t.start();

        TimeUnit.SECONDS.sleep(1);
        ex.stop();
    }

}
