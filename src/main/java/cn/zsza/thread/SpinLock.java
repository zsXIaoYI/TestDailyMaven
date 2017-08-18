package cn.zsza.thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by zs on 2017/8/18.
 * 11:55
 * 不可重入锁,同一个线程拿到锁,再次去拿锁,将会失败
 */
public class SpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<>();

    public void lock(){
        Thread current = Thread.currentThread();
        /**
         * cas 先和null比较,如果为null，则设置成current;不为null,则返回false
         */
        boolean flag = cas.compareAndSet(null, current);
        while(!flag){
            System.out.println("....lock");
        }
    }

    public void unLock(){
        Thread current = Thread.currentThread();
        cas.compareAndSet(current,null);
    }

    public static void main(String[] args) {
        final SpinLock spinLock = new SpinLock();
        System.out.println("invoke lock");
        spinLock.lock();
        System.out.println(" invoke lock success");
        System.out.println("try lock again");

        spinLock.lock();
        System.out.println("try lock success");
    }
}
