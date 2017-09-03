package cn.zsza.thread.proAndCons.demo1;

/**
 * Created by ZhangSong on 2017/9/3.
 * 21:36
 */
public class MyThread extends Thread {
    private MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.waitMethod();
    }

    /**
     * 只会打印A
     * @param args
     */
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThread my = new MyThread(myService);
        my.start();
    }
}
