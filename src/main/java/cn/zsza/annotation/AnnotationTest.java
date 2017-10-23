package cn.zsza.annotation;

import java.lang.reflect.Method;
/**
 * Created by zhangsong on 2017/10/19.
 */
public class AnnotationTest {


    @Permission(value = "hello")
    public void oneMethod(){

    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("cn.zsza.annotation.AnnotationTest");
            Method method = clazz.getDeclaredMethod("oneMethod");

            Permission permission = method.getAnnotation(Permission.class);
            System.out.println(permission.value()[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
