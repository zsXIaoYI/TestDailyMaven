package cn.zsza.java8;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ZhangSong on 2017/2/26.
 * 20:22
 */
public class FibonacciSupplier implements Supplier<Long> {
    long a = 0;
    long b = 1;

    /**
     * 0 1 1 2 3 5 8
       a b
         a b
     * @return
     */
    @Override
    public Long get() {
        long x = a + b;
        a = b;
        b = x;
        return a;
    }

    public static void main(String[] args) {
        Stream<Long> stream = Stream.generate(new FibonacciSupplier());
        /**
         * 下面一行代码执行后Stream会关闭，如果再继续下下行代码，则会
         *  java.lang.IllegalStateException: stream has already been operated upon or closed
         */
//        stream.limit(10).forEach(System.out::println);
        List<Long> collect = stream.limit(20).collect(Collectors.toList());
        System.out.println(collect);

        // 表示从第20开始打印斐波那契数列，打印10个
//        List<Long> longList = stream.skip(20).limit(10).collect(Collectors.toList());
//        System.out.println(longList);



    }


}
