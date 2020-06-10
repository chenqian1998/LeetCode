import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class addito10 {
    public static volatile AtomicInteger i = new AtomicInteger(0);

    public void add() {
        i.getAndIncrement();
    }


    // 10个线程保证i从一加到10
    public static void main(String[] args) throws InterruptedException {
        addito10 a = new addito10();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                a.add();
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "t" + String.valueOf(i)).start();
        }

        TimeUnit.SECONDS.sleep(2);
        System.out.println(i.get());
    }
}
