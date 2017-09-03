package cn.zsza.thread.proAndCons.demo2;

/**
 * Created by ZhangSong on 2017/9/3.
 * 21:12
 */
public class ThreadA extends Thread {
    private MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++){
            myService.set();
        }
    }
}
