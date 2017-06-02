package cn.zsza.thread;

/**
 * Created by zs on 2017/6/1.
 * 14:26
 */
public class ThreadLocalTest {

    private static class MyRunnable implements Runnable{

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "...get:" + threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable shared = new MyRunnable();

        Thread t1 = new Thread(shared);
        Thread t2 = new Thread(shared);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
