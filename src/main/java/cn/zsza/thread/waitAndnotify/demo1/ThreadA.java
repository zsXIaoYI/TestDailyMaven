package cn.zsza.thread.waitAndnotify.demo1;

/**
 * Created by ZhangSong on 2017/8/27.
 * 18:16
 */
public class ThreadA extends Thread {
    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    /**
     * wait()方法立即释放锁
     */
    @Override
    public void run() {
        try {
            synchronized (lock){
                if (MyList.size() != 5){
                    System.out.println("begin wait：" + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("end wait：" + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
