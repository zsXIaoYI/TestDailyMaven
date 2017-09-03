package cn.zsza.thread.syn;

public class SynTest {
	public static void main(String[] args) {
		Buffer buff = new Buffer();

		Writer writer = new Writer(buff);
		Reader reader = new Reader(buff);

		writer.start();
		reader.start();
		/**
		 * 我们期待“读”这个线程能退出等待锁，可是事与愿违，一旦读这个线程发现自己得不到锁，就一直开始等待了，就算它等死，也得不到锁，
		 * 因为写线程要21亿秒才能完成，即使我们中断它，它都不来响应下，看来真的要等死了
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
