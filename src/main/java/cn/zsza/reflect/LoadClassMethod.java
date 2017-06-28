package cn.zsza.reflect;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by user on 2016/3/5.
 */
public class LoadClassMethod {
    @Test
    public void testBegin() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("cn.zsza.reflect.Person");   // 加载类
        Constructor c = clazz.getConstructor();
        Person p = (Person) c.newInstance();

        Method method = clazz.getMethod("aa", null);    // 方法名为aa的无参方法
        method.invoke(p,null);
    }
    @Test
    public void test1() throws Exception{
        Person p = new Person();
        Class clazz = Class.forName("cn.zsza.reflect.Person");
        Method method = clazz.getMethod("aa", null);    // 方法名为aa的无参方法
        method.invoke(p,null);
    }

    /**
     * public void aa(String name,int age){}
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        Person p = new Person();
        Class clazz = Class.forName("cn.zsza.reflect.Person");
        Method method = clazz.getMethod("aa", String.class,int.class);
        method.invoke(p, "小伊伊", 18);
    }

    /**
     * public Class[] aa(String name,int socre[]){}
     * @throws ClassNotFoundException
     */
    @Test
    public void test3() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person p = new Person();
        Class clazz = Class.forName("cn.zsza.reflect.Person");
        Method method = clazz.getMethod("aa", String.class, int[].class);
        method.invoke(p,"cca",new int[]{1,2});
    }

    /**
     * private void aa(InputStream in){}
     * @throws Exception
     */
    @Test
    public void test4() throws Exception{
        Person p = new Person();
        Class clazz = Class.forName("cn.zsza.reflect.Person");
        Method method = clazz.getDeclaredMethod("aa", InputStream.class);
        method.setAccessible(true);
        method.invoke(p, new FileInputStream("file\\aa.txt"));
    }
    /*
	 * 静态方法反射
	 */
    @Test
    public void test5() throws Exception{
        new Person().aa1(2);
        Class clazz = Class.forName("cn.zsza.reflect.Person");
        Method method = clazz.getMethod("aa1", int.class);
        method.invoke(null, 23);
    }

    /**
     * 反射main方法
     * @throws Exception
     */
    @Test
    public void test6() throws Exception{
        Class clazz = Class.forName("cn.zsza.reflect.Person");
        Method method = clazz.getMethod("main", String[].class);
        method.invoke(null, (Object)new String[]{"aa","bb"});
    }
}
