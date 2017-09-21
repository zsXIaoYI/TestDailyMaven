package cn.zsza.thread.callable;

import java.util.concurrent.*;

/**
 * Created by user on 2016/6/12.
 */
public class CallableAddSum implements Callable<Integer> {
    private int start;
    private int end;
    private int sum;

    public CallableAddSum(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public Integer call() throws Exception {
        for (int i = start; i <end; i++) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * public interface ExecutorService extends Executor
         *
         * public class Executors
         *
         * Executors.newFixedThreadPool()
         * 使用一个基于链表结构的阻塞队列(LinkedBlockingQueue)，此队列安FIFO排序元素，吞吐量通常要高于ArrayBlockingQueue
         */
        ExecutorService pool = Executors.newFixedThreadPool(2);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        /**
         * 开启两个线程求 1 到 100 的 和
         */
        Future<Integer> f1 = pool.submit(new CallableAddSum(1, 50));
        Future<Integer> f2 = pool.submit(new CallableAddSum(50, 101));
        
        
        Integer s1 = f1.get();
        Integer s2 = f2.get();
        System.out.println(s1 + s2);
        pool.shutdown();

        if (!pool.awaitTermination(10,TimeUnit.NANOSECONDS)){
            System.out.println("Threads did not finish in 60 NANOSECONDS");
        }
        System.out.println(pool.isShutdown());
        System.out.println(pool.isTerminated());

    }

}
