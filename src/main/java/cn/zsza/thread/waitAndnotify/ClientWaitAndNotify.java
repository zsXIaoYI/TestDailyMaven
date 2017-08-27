package cn.zsza.thread.waitAndnotify;

import cn.zsza.thread.waitAndnotify.demo1.ThreadA;
import cn.zsza.thread.waitAndnotify.demo1.ThreadB;

/**
 * Created by ZhangSong on 2017/8/27.
 * 18:25
 */
public class ClientWaitAndNotify {
    public static void main(String[] args) {

        try {
            Object lock = new Object();
            ThreadA ta = new ThreadA(lock);
            ta.start();
            Thread.sleep(50);
            ThreadB tb = new ThreadB(lock);
            tb.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
