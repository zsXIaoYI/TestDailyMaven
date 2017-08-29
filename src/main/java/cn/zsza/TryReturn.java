package cn.zsza;

/**
 * Created by zs on 2017/8/29.
 * 10:08
 */
public class TryReturn {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        int sum = testTryReturn(a, b);
        System.out.println(sum);
    }

    /**
     * finally先于return执行
     * @param a
     * @param b
     * @return
     */
    private static int testTryReturn(int a,int b) {
        try {
            return a + b;
        }finally {
            System.out.println("finally........");
        }
    }
}
