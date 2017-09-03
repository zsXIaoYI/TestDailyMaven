package cn.zsza.thread.proAndCons.demo2;

/**
 * Created by ZhangSong on 2017/9/3.
 * 21:12
 */
public class ThreadB extends Thread {
    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++){
            myService.get();
        }
    }
}
