package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class myLockDemo{
    public static void main(String[] args) {
        MyLock lock = new MyLock();

        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"locking...");
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"locking...");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName()+"unlocking...");
                lock.unlock();
            }
        },"t1").start();

//        new Thread(() -> {
//            lock.lock();
//            try {
//                System.out.println(Thread.currentThread().getName()+"locking...");
//            }finally {
//                System.out.println(Thread.currentThread().getName()+"unlocking...");
//                lock.unlock();
//            }
//        },"t2").start();
    }
}


// 写一个自定义的锁：不可重入锁
class MyLock implements Lock {

    // 同步器类
    class MySync extends AbstractQueuedSynchronizer {
        @Override // 尝试获取锁
        protected boolean tryAcquire(int arg) {
            // 修改state的值，采用cas的方式
            if (compareAndSetState(0, 1)) {
                // 并且设置
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            // 直接可以释放锁，应为当前线程调用这方法已经
            setState(0);
            setExclusiveOwnerThread(null);
            return true;
        }


        @Override // 是否持有独占锁
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        public Condition newCondition() {
            return new ConditionObject();
        }
    }

    // 下面加锁的功能都是通过同步器来实现的
    private MySync sync = new MySync();

    @Override
    public void lock() {
        // 尝试加锁，如果不成功就加入等待队列
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }


}
