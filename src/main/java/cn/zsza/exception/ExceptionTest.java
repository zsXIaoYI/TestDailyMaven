package cn.zsza.exception;

import org.junit.Test;

/**
 * Created by ZhangSong on 2017/8/27.
 * 18:07
 */
public class ExceptionTest {
    @Test
    public  void testIllegalMonitorStateException(){
        try {
            String newString = new String("");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
