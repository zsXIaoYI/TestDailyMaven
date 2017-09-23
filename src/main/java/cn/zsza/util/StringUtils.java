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

    /**
     * 求一个字符串中最长回文子串
     * @param str
     * @return
     */
    public static int longestPalindRome(String str){
        if (str == null || str.length() < 1){
            return 0;
        }
        int max = 0, current = 0, length = str.length();
        // 循环 每个字符作为回文的中点
        for (int i = 0; i < length; i++) {
            // 考虑回文子串长度为奇数的情况
            for (int j = 0; i - j >=0 && i + j < length ; j++) {
                if(str.charAt(i - j) != str.charAt(i + j)){
                    break;
                }
                current = j * 2 + 1;
            }
            if (current > max){
                max = current;
            }

            current = 0;
            // 考虑回文子串长度为偶数的情况
            for (int j = 0; (i - j >= 0) && (i + j + 1 < length) ; j++) {
                if (str.charAt(i - j) != str.charAt(i + j + 1)){
                    break;
                }
                current = j * 2 + 2;
            }
            if (current > max){
                max = current;
            }

        }
        return max;
    }
}
