package cn.zsza.util;

import java.util.Comparator;

/**
 * Created by zs on 2017/7/20.
 * 11:23
 */
public class StrLenCom implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()){
            return 1;
        }
        if (o1.length() < o2.length()){
            return -1;
        }
        return o1.compareTo(o2);
    }
}