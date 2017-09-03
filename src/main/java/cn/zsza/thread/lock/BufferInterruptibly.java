package cn.zsza.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class BufferInterruptibly {
	private ReentrantLock lock = new ReentrantLock();

	public void write() {
		lock.lock();
		try {
			long start = System.currentTimeMillis();
			System.out.println("开始写数据......");
			for(;;){
				if (System.currentTimeMillis() - start > Integer.MAX_VALUE) {
					break;
				}
			}
			System.out.println("终于写完了....");
		} finally {
			lock.unlock();
		}
	}

	public void read() throws InterruptedException {
		lock.lockInterruptibly();
		try {
			System.out.println("开始读数据....");
		} finally {
			lock.unlock();
		}
	}

}
