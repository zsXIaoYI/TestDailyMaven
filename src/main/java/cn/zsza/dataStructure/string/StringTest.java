package cn.zsza.dataStructure.string;

import cn.zsza.util.StringUtils;
import org.junit.Test;

/**
 * Created by ZhangSong on 2017/8/27.
 * 21:31
 */
public class StringTest {
    /**
     * 判断字符串是否为回文串
     */
    @Test
    public void test1(){
        System.out.println(StringUtils.isPalindrome("abcdcba"));
        System.out.println(StringUtils.isPalindrome("abcdhba"));
    }
}
