package cn.zsza.regex;

import org.junit.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    /**
     * E-mail正则表达式
     */
    @Test
    public void test2(){
        String str = "zsza5466@sina.com";
        Pattern p = Pattern.compile("[a-z0-9_]+@[a-z0-9]+\\.[a-z]+");
        Matcher m = p.matcher(str);
        System.out.println(m.matches());
    }
}
