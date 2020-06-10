package JVM;

import java.util.concurrent.TimeUnit;

/**
 * 优雅的停止线程
 */
public class TwoPhaseTermination {
    //
    private Thread monitorThread;

    private volatile static boolean stop = false;

    public void start() {
        monitorThread = new Thread(() -> {
            while (true) {
                if (stop) {
                    // 处理一些善后操作，比如释放资源。。
                    break;
                }
                // 正常的业务逻辑
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        });
        monitorThread.start();
    }

    public void stop() {
        stop = true;
        // 比如说上面的线程正在sleep(1)，我们打断睡眠，直接开始下一层循环
        monitorThread.interrupt();
    }
}
