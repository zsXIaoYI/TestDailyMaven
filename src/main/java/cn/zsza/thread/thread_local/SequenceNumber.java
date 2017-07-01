package cn.zsza.thread.thread_local;

/**
 * Created by zs on 2017/6/1.
 * 14:26
 */
public class SequenceNumber {

    /**
     * Java8表达式
     */
    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    public int getNextNum(){
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }
    private static class MyRunnable extends Thread{
        private SequenceNumber sn;

        public MyRunnable(SequenceNumber sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            for (int i = 0;i < 3; i++){
                System.out.println("线程:" + Thread.currentThread().getName() + " sn: " + sn.getNextNum());
            }
        }
    }

    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();

        MyRunnable m1 = new MyRunnable(sn);
        MyRunnable m2 = new MyRunnable(sn);

        m1.start();
        m2.start();
    }

}
