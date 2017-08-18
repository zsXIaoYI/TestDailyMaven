package cn.zsza.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zs on 2017/8/18.
 * 11:29
 */
public class ReentrantLockTest {
    /**
     * 可重入锁
     */
    private ReentrantLock lock = new ReentrantLock();

    public void doFirstLock(){
        lock.lock();
        try {
            System.out.println("doFirstLock---" + Thread.currentThread().getId());
            doSecondLock();
        }finally {
            lock.unlock();
        }
    }

    private void doSecondLock() {
        lock.lock();
        try {
            System.out.println("doSecondLock---" + Thread.currentThread().getId());
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++){
            new Thread(){
                @Override
                public void run() {
                    new ReentrantLockTest().doFirstLock();
                }
            }.start();
        }
        TimeUnit.SECONDS.sleep(10 * 1);
    }

}
