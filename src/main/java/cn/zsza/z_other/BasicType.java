package cn.zsza.z_other;

/**
 * Created by ZhangSong on 2017/9/27.
 * 10:30
 */
public class BasicType {
    public static void main(String[] args) {
        char a = 'a';
        char b = '1';

        // 得到a的ASCII
        int val = a;
        // 得到b对应的数值
        System.out.println("val:" + val);
        int val1 = Character.getNumericValue(b);
        System.out.println("val1: " + val1);

        /***/
        double d = 12.345;
        float f = 12.3f;
        System.out.println(100.0 % 3);
    }
}
