package cn.zsza.thread.interrupt;

/**
 * Created by zs on 2017/7/18.
 * 15:44
 */
public class MyRunnableInterrupt implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("in run() - about to sleep for 20 seconds");
            Thread.sleep(20000);
            System.out.println("in run() - woke up");
        } catch (InterruptedException e) {

            System.out.println("in run() - interrupted while sleeping");
            // 如果没有return，线程不会实际被中断，它会继续打印下面的信息
            return;
        }
        System.out.println("in run() - leaving normally");
    }

    public static void main(String[] args) {
        MyRunnableInterrupt myRunnableInterrupt = new MyRunnableInterrupt();
        Thread t = new Thread(myRunnableInterrupt);
        t.start();
        /**
         * 主线程休眠两秒后，执行中断其他线程的操作
         */
        try {
            System.out.println("Current thread:" + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in main() - interrupting other thread");
        /**
         * 当执行的线程在进行休眠操作时,执行t.interrupt操作,会
         * 报异常:java.lang.InterruptedException
         */
        t.interrupt();
        System.out.println("in main() - leaving");
    }
}
