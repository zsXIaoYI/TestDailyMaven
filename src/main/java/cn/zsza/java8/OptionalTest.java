package cn.zsza.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by zs on 2017/7/28.
 * 17:59
 */
public class OptionalTest {

    private Optional<String> s1 = Optional.of("hello");


    @Test
    public void test1(){
        System.out.println(s1.get());

        /**
         * 当s2位空时,调用get()方法,返回:java.util.NoSuchElementException: No value present
         */
        Optional<String> s2 = Optional.ofNullable(null);
//        System.out.println("s2:" + s2.get());

        String s3 = s2.orElse("not null");
        System.out.println("s3:" + s3);

    }
    @Test
    public void test2(){
        s1.ifPresent(str -> insert(str.length()));
    }

    public void insert(int length){
        System.out.println("len:" + length);
    }
}
