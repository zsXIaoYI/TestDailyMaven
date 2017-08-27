package cn.zsza.thread.waitAndnotify.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangSong on 2017/8/27.
 * 18:14
 */
public class MyList {
    private static List list = new ArrayList();

    public static void add(){
        list.add("anything");
    }

    public static int size(){
        return list.size();
    }
}
