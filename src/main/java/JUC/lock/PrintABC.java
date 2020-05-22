package JUC.lock;

import sun.jvm.hotspot.runtime.Thread;

import java.net.HttpURLConnection;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    private volatile int flag = 1;

    // 打印顺序的一个问题,有三个线程，每个线程只打印A ,B, C
    public void printA() {
        lock.lock();
        try {
            while (flag != 1) {
                conditionA.await();
            }
            System.out.println("A");
            conditionB.signal();
            flag = 2;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (flag != 2) {
                conditionB.await();
            }
            System.out.println("B");
            conditionC.signal();
            flag = 3;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (flag != 3) {
                conditionC.await();
            }
            System.out.println("C");
            conditionA.signal();
            flag = 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();

    }

}
