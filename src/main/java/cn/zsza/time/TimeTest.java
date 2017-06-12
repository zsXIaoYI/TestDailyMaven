package cn.zsza.time;

import org.junit.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Created by zs on 2017/6/12.
 * 14:56
 */
public class TimeTest {

    /**
     * 把毫秒转换成时间
     */
    @Test
    public void test1(){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(new Date().getTime());
        System.out.println("time:" + formatter.format(calendar.getTime()));
    }
}
