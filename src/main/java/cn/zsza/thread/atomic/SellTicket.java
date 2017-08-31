package cn.zsza.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zs on 2017/8/31.
 * 14:41
 */
public class SellTicket {
    AtomicInteger tickets = new AtomicInteger(100);

    class Seller implements Runnable{

        @Override
        public void run() {
            while (tickets.get() > 0){
                int tmp = tickets.get();
                if (tickets.compareAndSet(tmp,tmp - 1)){
                    System.out.println(Thread.currentThread().getName() + " " + tmp);
                }
            }
        }
    }

    public static void main(String[] args) {
        SellTicket st = new SellTicket();
        new Thread(st.new Seller(),"sA").start();
        new Thread(st.new Seller(),"sB").start();
    }
}
