package cn.zsza.time;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
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

    /**
     * 给定两个日期,求两个日期相隔天数
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int daysOfTwoDate(String startDate,String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date fDate=sdf.parse(startDate);
        Date oDate=sdf.parse(endDate);
        int days=(int) ((oDate.getTime()-fDate.getTime())/(1000*3600*24));
        return days;
    }
    /**
     * @param strDate    开始日期
     * @param afterDay   几天
     * @return           开始日期后的几天日期
     */
    public static String getDateOfAfter(String strDate,int afterDay) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (strDate == null || "".equals(strDate)) {
                Date date = new Date();
                strDate = format.format(date);
            }
            Date myDate = format.parse(strDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(myDate);
            calendar.add(Calendar.DAY_OF_MONTH, afterDay);
            myDate = calendar.getTime();
            return format.format(myDate);
        } catch (Exception e) {
        }
        return "";
    }
    @Test
    public void test() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse("2017-02-25 10:28:50");
        Date date2 = sdf.parse("2017-02-28 10:30:20");


        long c1 = date1.getTime();

        long c2 = date2.getTime();



        System.out.println("c1:" + c1);
        System.out.println("c2:" + c2);


    }

    public static void main(String[] args) throws ParseException {
        System.out.println(daysOfTwoDate("2017-02-25 10:28:50","2017-02-28 10:30:20"));
        System.out.println(getDateOfAfter("2017-02-16",5));
    }
}
