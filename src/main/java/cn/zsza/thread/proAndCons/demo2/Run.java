package cn.zsza.thread.proAndCons.demo2;

/**
 * Created by ZhangSong on 2017/9/3.
 * 21:14
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();

        ThreadA ta = new ThreadA(myService);
        ThreadB tb = new ThreadB(myService);

        ta.start();
        tb.start();
    }
}
