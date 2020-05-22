package JUC.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/4/17 9:15 下午
 */
public class DeadLock {
    final Object  object1 = new Object();
    final Object object2 = new Object();

    public void lock1() throws InterruptedException {
        synchronized (object1) {
            TimeUnit.SECONDS.sleep(1);
            synchronized (object2) {

            }
        }
    }

    public void lock2() throws InterruptedException {
        synchronized (object2) {
            TimeUnit.SECONDS.sleep(1);
            synchronized (object1) {

            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(() -> {
            try {
                deadLock.lock1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(() -> {
            try {
                deadLock.lock2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
