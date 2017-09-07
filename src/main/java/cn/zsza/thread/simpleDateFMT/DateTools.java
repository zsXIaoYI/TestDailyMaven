package cn.zsza.thread.simpleDateFMT;

import java.text.SimpleDateFormat;

/**
 * Created by ZhangSong on 2017/9/7.
 * 21:58
 */
public class DateTools {
    private static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<>();
    public static SimpleDateFormat getSimpleDateFormat(String datePattern){
        SimpleDateFormat sdf = null;
        sdf = t1.get();
        if (sdf == null){
            sdf = new SimpleDateFormat(datePattern);
            t1.set(sdf);
        }
        return sdf;
    }
}
