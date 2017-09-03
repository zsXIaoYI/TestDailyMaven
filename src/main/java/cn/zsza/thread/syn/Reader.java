package cn.zsza.thread.syn;

public class Reader extends Thread {
	private Buffer buff;

	public Reader(Buffer buff) {
		this.buff = buff;
	}

	@Override
	public void run() {
		buff.read();
		System.out.println("读结束....");
	}

}
