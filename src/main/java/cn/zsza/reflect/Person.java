package cn.zsza.reflect;

import java.io.InputStream;
import java.util.List;

/**
 * Created by user on 2016/3/5.
 */
public class Person {
    public String name = "小伊伊";
    private int pwd;
    private static int age;
    public Person(){
        System.out.println("Person无参构造");
    }
    public Person(String name){
        System.out.println("Person name:"+name);
    }
    public Person(String name,int age){
        System.out.println("Person name...age");
    }
    private Person(List list){
        System.out.println("Listing");
    }

    public void aa(){
        System.out.println("我是aa无参方法");
    }
    public void aa(String name,int age){
        System.out.println("大家好，我叫"+name+"我今年"+age);
    }
    public Class[] aa(String name,int socre[]){
        System.out.println("大家好，我叫"+name);
        return new Class[]{String.class};
    }
    private void aa(InputStream in){
        System.out.println("in="+in);
    }

    public static void aa1(int num){
        System.out.println("num="+num);
    }
    public static void bb(){
        System.out.println("bb静态方法");
    }

    public static void main(String[] args) {
        System.out.println("main方法");
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1.equals(p2));

    }
}
