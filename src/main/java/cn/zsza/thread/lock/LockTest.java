package cn.zsza.thread.lock;

public class LockTest {
	public static void main(String[] args) {
		BufferInterruptibly  buff = new BufferInterruptibly ();

		Writer writer = new Writer(buff);
		Reader reader = new Reader(buff);

		writer.start();
		reader.start();
		/**
		 * ReentrantLock给了一种机制让我们来响应中断，让“读”能伸能屈，勇敢放弃对这个锁的等待
		 */

		new Thread(() -> {
            long start = System.currentTimeMillis();
            for(;;){
                if (System.currentTimeMillis() - start > 5000) {
                    System.out.println("不等了，尝试中断");
                    reader.interrupt();
                    break;
                }
            }
        }).start();

	}
}
