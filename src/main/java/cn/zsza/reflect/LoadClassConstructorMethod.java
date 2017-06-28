package cn.zsza.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/3/5.
 */
public class LoadClassConstructorMethod {
    /**
     * 解剖无参构造函数
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        Class clazz = Class.forName("cn.zsza.reflect.Person");   // 加载类
        Constructor c = clazz.getConstructor();
        Person p = (Person) c.newInstance();
        System.out.println(p.name);
    }

    /**
     * 解剖有参的构造函数
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        Class clazz = Class.forName("cn.zsza.reflect.Person");
        Constructor c = clazz.getConstructor(String.class);  // 指定构造函数的参数类型
        Person p = (Person) c.newInstance("cc");             // 构造函数参数
        System.out.println(p.name);
    }

    /**
     * 反射有2个参数的构造方法
     * @throws Exception
     */
    @Test
    public void test3() throws Exception{
        Class clazz = Class.forName("cn.zsza.reflect.Person");
        Constructor c = clazz.getConstructor(String.class,int.class);
        Person p = (Person) c.newInstance("cc",18);
        System.out.println(p.name);
    }

    /**
     * 反射私有的构造方法
     * @throws Exception
     */
    @Test
    public void test4() throws Exception{
        Class clazz = Class.forName("cn.zsza.reflect.Person");
        Constructor c = clazz.getDeclaredConstructor(List.class);
        c.setAccessible(true);   //暴力反射
        Person p = (Person) c.newInstance(new ArrayList());
        System.out.println(p.name);
    }
    /**
     * 创建无参构造的另一种形式
     * @throws Exception
     */
    @Test
    public void test5() throws Exception{
        Class clazz = Class.forName("cn.zsza.reflect.Person");
        Person p = (Person) clazz.newInstance();
        System.out.println(p.name);
    }
}
