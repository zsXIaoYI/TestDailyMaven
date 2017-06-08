package cn.zsza.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * Created by zs on 2017/6/8.
 * 16:43
 */
class Student{
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int hashCode() {
        System.out.println(this.name+" hashcode");
        return name.hashCode()+age*34;
    }
    public boolean equals(Object obj){
        System.out.println("equals");
        if(!(obj instanceof Student))
            throw new ClassCastException("类型不匹配");
        Student s = (Student) obj;
        return this.name.equals(s.name)&&this.age==s.age;
//        return false;
    }
    public String toString() {
        return name+"..."+age;
    }
}
public class MapOfStudent {
    public static void main(String[] args) {
        Map<Student,String> map = new HashMap<Student, String>();
        /**
         * 当以Student对象作为key存储时
         * 下面两行代码，其存入的两个对象的hashcode值一样，则会调用equals方法，
         *   equals方法返回true,则不能存入；返回false，则能存入
         */
        map.put(new Student("aa", 11), "beijing");
        map.put(new Student("ab", 11), "nanjing");

        String city = map.get(new Student("aa", 11));     // 返回nanjing，改行new出的对象和map中的key对象hashcode一样
        System.out.println("city="+city);

        Set<Student> keySet = map.keySet();
        Iterator<Student> it = keySet.iterator();    //map.keySet().iterator()
        while(it.hasNext()){
            Student stu = it.next();
            String addr = map.get(stu);
            System.out.println(stu+"..."+addr);
        }
    }
}
