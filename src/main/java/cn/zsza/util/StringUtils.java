package cn.zsza.util;

/**
 * Created by ZhangSong on 2017/8/27.
 * 21:26
 */
public class StringUtils {
    /**
     * 判断是否为回文串
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str){
        if (str == null || str.length() == 0){
            throw new RuntimeException("字符串为空");
        }
        int length = str.length();
        int middle = (length - 1) / 2;
        for (int i = 0; i <= middle; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i))
                return false;
        }
        return true;
    }
}
