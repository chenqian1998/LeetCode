package JUC;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BasicPrint {
    private ReentrantLock lock = new ReentrantLock();
    private int flag = 1;
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (flag != 1) {
                condition1.await();
            }
            System.out.println("A");
            condition2.signal();
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
                condition2.await();
            }
            System.out.println("B");
            condition3.signal();
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
                condition3.await();
            }
            System.out.println("C");
            condition1.signal();
            flag = 3;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


/**
 * 这个问题其实考的是 lock 和 condition
 */
public class 顺序打印ABC {
    public static void main(String[] args) {

    }

}
