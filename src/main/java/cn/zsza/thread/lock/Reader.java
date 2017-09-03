package cn.zsza.thread.lock;

public class Reader extends Thread {
	private BufferInterruptibly  buff;

	public Reader(BufferInterruptibly buff) {
		this.buff = buff;
	}

	@Override
	public void run() {
		try {
			buff.read();
		} catch (InterruptedException e) {
			System.out.println("我不读了...." + e);
		}
		System.out.println("读结束....");
	}



}
