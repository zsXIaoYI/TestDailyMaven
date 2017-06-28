package cn.zsza.reflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by zs on 2017/4/27.
 * 17:03
 */
public class ClassTest {

    @Test
    public void test1() throws ClassNotFoundException {
        System.out.println("当前线程:" + Thread.currentThread().getName());
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        Class<?> aClass = loader.loadClass("cn.zsza.reflect.Person");

        Method[] methods = aClass.getMethods();
        for (Method method : methods){
            System.out.println("method name=" + method.getName());
        }
    }
}
