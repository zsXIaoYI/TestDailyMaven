package cn.zsza.thread.proAndCons.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ZhangSong on 2017/9/3.
 * 21:03
 */
public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private boolean hasValue = true;

    public void set(){
        try {
            lock.lock();
            while (hasValue == true){
                condition.await();
            }
            System.out.println("打印★");
            hasValue = true;
            condition.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("..set");
            lock.unlock();
        }
    }
    public void get(){
        try {
            lock.lock();
            while (hasValue == false){
                condition.await();
            }
            System.out.println("打印☆");
            hasValue = false;
            condition.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("..get");
            lock.unlock();
        }
    }
}
