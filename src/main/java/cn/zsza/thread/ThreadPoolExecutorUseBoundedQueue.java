package cn.zsza.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * Created by zs on 2017/8/18.
 * 16:27
 * 使用有界队列
 */
public class ThreadPoolExecutorUseBoundedQueue implements Runnable {
    private String name;

    public ThreadPoolExecutorUseBoundedQueue(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("-->" + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 分析:线程池的corePoolSize为1，任务1提交后，线程开始执行，corePoolSize 数量用完，接着任务2、3、4提交，放到了有界队列中，此时有界队列也满了。
     * 继续提交任务5，由于当前运行的线程数poolSize < maximumPoolSize,线程池尝试new一个新的线程来执行任务5，所以任务5会接着执行。
     * 当继续提交任务6时，poolSize达到了maximumPoolSize，有界队列也满了，所以线程池执行了拒绝操作。
     * @param args
     */

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(3);
        ThreadPoolExecutor threadPool =
                new ThreadPoolExecutor(1,2,1L, TimeUnit.SECONDS,workQueue);
        threadPool.execute(new ThreadPoolExecutorUseBoundedQueue("任务1"));
        threadPool.execute(new ThreadPoolExecutorUseBoundedQueue("任务2"));
        threadPool.execute(new ThreadPoolExecutorUseBoundedQueue("任务3"));
        threadPool.execute(new ThreadPoolExecutorUseBoundedQueue("任务4"));
        threadPool.execute(new ThreadPoolExecutorUseBoundedQueue("任务5"));
        threadPool.execute(new ThreadPoolExecutorUseBoundedQueue("任务6"));
        threadPool.shutdown();
    }
}