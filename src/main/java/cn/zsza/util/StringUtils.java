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
    public static String addBySum(String s1,String s2){
        /**
         * s1 =999 378
         * s2 =    123
         */
        String resultTmp = null;
        StringBuffer result = new StringBuffer();
        StringBuffer result3 = new StringBuffer();
        String r3 = null;
        int leth1 = s1.length();
        int leth2 = s2.length();
        int leth1_2 = leth1 - leth2;
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        int temp = 0;                    // 进位,两数相加和大于10，则往高位进1
        int res;
        if (leth1 >= leth2){
            /**
             * 先计算s1和s2等长度的两者之间的和
             */
            for (int i = leth2 - 1; i >= 0 ; i--) {
                res = Character.getNumericValue(c1[i + leth1_2]) +
                        Character.getNumericValue(c2[i]) + temp;
                String resTmp = "" + res ;
                if (res >= 10){
                    temp = 1;    // 往高位进1
                    result.append(resTmp.charAt(1));
                    System.out.println();
                }else {
                    temp = 0;
                    result.append(resTmp);
                }
            }
            // 如果前面for循环中有进位，则对其s1.substring(0,leth1 - leth2)计算要+1
            if (temp > 0){
                if (leth1 > leth2){
                    String s3 = s1.substring(0,leth1 - leth2);
                    char c3[] = s3.toCharArray();
                    int leth3 = c3.length;
                    for (int i = leth3 - 1; i >= 0 ; i--) {
                        int r = Character.getNumericValue(c3[i]) + temp;
                        String rTmp = "" + r;
                        if (r >= 10){
                            temp = 1;  // 往高位进1
                            result3.append(rTmp.charAt(1));
                            /**
                             * 999
                             *   1
                             */
                            if (i == 0){
                                r3 = "1";
                            }
                        }else {
                            r3 = new String(c3, 0, i);
                            result3.append(rTmp);
                            break;
                        }
                    }
                    String finalR3 = r3 + result3.reverse().toString();
                    resultTmp = finalR3 + result.reverse().toString();
                }else if (leth1 == leth2){      // 如果字符串长度相等，则进位1 + result.reverse().toString()
                    resultTmp = "1" + result.reverse().toString();
                }
            }else {
                resultTmp = s1.substring(0,leth1 - leth2) + result.reverse().toString();
            }
        }
        return resultTmp;
    }

    /**
     *
     * @param s1
     * @param s2 对较短的s2进行补零
     * @return
     */
    public static String addBySum2(String s1,String s2){
        String resultTmp;
        StringBuffer result = new StringBuffer();
        int leth1 = s1.length();
        int leth2 = s2.length();
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        int temp = 0;                    // 进位,两数相加和大于10，则往高位进1
        int res;
        if (leth1 > leth2){              // 进行补零操作
            c2 = (getSb0(leth1,leth2) + s2).toCharArray();
        }
        for (int i = leth1 - 1; i >= 0 ; i--) {
            res = Character.getNumericValue(c1[i]) +
                    Character.getNumericValue(c2[i]) + temp;
            String resTmp = "" + res ;
            if (res >= 10){
                temp = 1;  // 往高位进1
                result.append(resTmp.charAt(1));
            }else {
                temp = 0;
                result.append(resTmp);
            }
        }
        if (temp == 0){
            resultTmp = result.reverse().toString();
        }else {
            resultTmp = "1" + result.reverse().toString();
        }
        return resultTmp;
    }

    private static String getSb0(int leth1,int leth2){
        StringBuffer sb0 = new StringBuffer();
        if (leth1 >= leth2){
            for (int i = 0; i < leth1 - leth2; i++) {
                sb0.append("0");
            }
        }
        return sb0.toString();
    }


    public static void main(String[] args) {
        System.out.println(addBySum("12923","123"));
        System.out.println(addBySum2("199923","123"));


    }
}
