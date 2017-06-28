package cn.zsza.reflect;

/**
 * Created by user on 2016/4/18.
 */
public class LoadingTest {
    final
    public static LoadingTest obj = new LoadingTest();
    public static int value1;
    public static int value2 = 0;

    public LoadingTest() {
        value1 = 10;
        value2 = value1;
        System.out.println("before value1->" + value1);
        System.out.println("before value2->" + value2);
    }

    public static void main(String[] args) {
        final int a;
        System.out.println("after value1->" + value1);
        System.out.println("after value2->" + value2);
    }
}
