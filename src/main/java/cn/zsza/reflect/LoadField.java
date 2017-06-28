package cn.zsza.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by user on 2016/3/5.
 */
public class LoadField {
    @Test
    public void test1() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Person p = new Person();
        Class clazz = Class.forName("cn.zsza.reflect.Person");
        Field f = clazz.getField("name");         // 得到字段
        Object o = f.get(p);
        Class type = f.getType();           // 判断字段的类型
        if (type.equals(String.class)){
            String oValue = (String) o;
            System.out.println(oValue);
        }
        System.out.println("o="+o);
    }

    /**
     * 反射私有成员
     * @throws ClassNotFoundException
     */
    @Test
    public void test2() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Person p = new Person();
        Class clazz = Class.forName("cn.zsza.reflect.Person");
        Field f = clazz.getDeclaredField("pwd");
        f.setAccessible(true);
        Object o = f.get(p);
        System.out.println(o);
    }
}
