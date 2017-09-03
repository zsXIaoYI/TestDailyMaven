package cn.zsza.thread.waitAndnotify.demo1;

/**
 * Created by ZhangSong on 2017/8/27.
 * 18:21
 */
public class ThreadB extends Thread {
    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    /**
     * notify()方法并不会立即释放锁，执行完synchronized代码块后才释放锁
     */
    @Override
    public void run() {
        try {
            synchronized (lock){
                for (int i = 0; i < 10; i++){
                    MyList.add();
                    System.out.println("添加了" + (i + 1) + "个元素");
                    if (MyList.size() == 5){
                        lock.notify();
                        System.out.println("已发出通知...");
//                        break;
                    }
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
