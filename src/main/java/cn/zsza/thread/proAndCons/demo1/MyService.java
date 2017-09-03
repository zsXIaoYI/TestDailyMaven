package cn.zsza.thread.proAndCons.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ZhangSong on 2017/9/3.
 * 21:34
 */
public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     * 调用了Condition对象的await()方法，使当前执行任务的线程进入了等待WAITING状态
     */
    public void waitMethod(){
        try {
            lock.lock();
            System.out.println("A");
            condition.await();
            System.out.println("B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("释放锁....");
        }
    }
}
