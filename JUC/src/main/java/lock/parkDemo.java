package lock;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class parkDemo {
    public static void main(String[] args) {
        Object object = new Object();
        Thread t1 = new Thread(() -> {
            System.out.println("zhunbei");
            //LockSupport.park();
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("adsada");
        }, "name");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();
        System.out.println(t1.isInterrupted());

    }
}
