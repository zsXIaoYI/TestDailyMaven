package cn.zsza.dataStructure.other;

/**
 * Created by zs on 2017/8/2.
 * 11:57
 *
 * 非递归方式实现斐波那契数列
 * 0 1 1 2 3 5 8
 * a b
 *   a b
 */
public class Fibonacci {

    public static long getN(int n){
        int result[] = {0,1};
        if (n < 2)
            return result[n];
        long a = 0;
        long b = 1;
        for (int i = 2; i <= n; i++){
            long x = a + b;
            a = b;
            b = x;
        }
        return a;
    }

    public static void main(String[] args) {
        long n = getN(5);
        System.out.println(n);
    }

}
