package cn.zsza.zs_base.entity;

import lombok.Data;

/**
 * Created by zs on 2017/7/27.
 * 14:36
 */
@Data
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int hashCode() {
        return name.hashCode()+age*34;
    }
    public boolean equals(Object obj){
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
