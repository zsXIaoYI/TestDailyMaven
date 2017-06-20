package cn.zsza.regex;

import org.junit.Test;

/**
 * Created by zs on 2017/6/20.
 * 18:28
 */
public class RegexTest {
    /**
     *把手机号中间四位替换成“*”
     */
    @Test
    public void test1(){
        String  str = "15631150440";
        System.out.println(str.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
    }
}
