package JUC.线程创建;

import org.junit.Test;

import java.util.concurrent.*;

class job implements Runnable {

    @Override
    public void run() {
        System.out.println("__test__");
    }
}
/**
 * Runnable接口和callbale接口有什么不同
 */

/**
 * @author liulixiashu
 */
public class 线程池 {
    public static void main(String[] args) {
        ThreadPoolExecutor jobPool = new ThreadPoolExecutor(
                2, 5, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                // AbortPolicy是会抛出异常的
                new ThreadPoolExecutor.AbortPolicy()
        );
        Runnable job = new job();
        Callable job2 = new job2();
        for (int i = 0; i < 1000; i++) {
            try {
                // execute(Runnable)

                // jobPool.execute(job);

                Future submit = jobPool.submit(job2);
                System.out.println(submit.get());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        // 要关闭资源
        jobPool.shutdown();

    }
}
