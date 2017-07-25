package cn.zsza.zs_base.entity;

import lombok.Data;
/**
 * 1.hashCode返回值不同，就不会执行equals。就可以共存。
 * 2.hashCode返回值相同，就会执行equals.执行了equals方法返回true,就不可以共存；
 * 返回false,就可以共存。
 */
@Data
public class PP {
    private String name;
    private int age;
    public PP(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int hashCode() {
        System.out.println(this.name+"执行hashCode().....");
        return name.hashCode()+age;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof PP))
            return false;
        PP p = (PP) obj;
        System.out.println(this.name+"...equals..."+p.name);
        return this.name.equals(p.name)&&this.age==p.age;
//        return false;
    }
}