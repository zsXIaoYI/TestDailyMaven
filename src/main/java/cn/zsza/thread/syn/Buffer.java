package cn.zsza.thread.syn;

public class Buffer {
	private Object lock;

	public Buffer() {
		lock = this;
	}
	public void write() {
		synchronized(lock){
			long startTime = System.currentTimeMillis();
			System.out.println("...开始写数据");
			for(;;){
				if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE) {
					break;
				}
			}
			System.out.println("终于写完了");
		}
	}


	public void read() {
		synchronized (lock) {
			System.out.println("读数据.....");
		}

	}


}
