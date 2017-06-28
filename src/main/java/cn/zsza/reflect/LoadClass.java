package cn.zsza.reflect;

/**
 * Created by user on 2016/3/5.
 */
public class LoadClass {
    /**
     * 反射，加载类，获得字节码
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // 加载类 的三种方法
        // ClassNotFoundException: cn.zsza.reflect.Persons
        Class clazz = Class.forName("cn.zsza.reflect.Person");

        Class  clazz1 = new Person().getClass();

        Class clazz2 = Person.class;

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?> aClass = loader.loadClass("cn.zsza.reflect.Person");



        System.out.println(clazz);
        String name = clazz.getCanonicalName();
        System.out.println("name="+name);
    }
}
