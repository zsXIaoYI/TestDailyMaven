package cn.zsza.zs_base.entity;

/**
 * Created by zs on 2017/7/20.
 * 14:54
 */
public class Person{
    private int idNum;

    public Person(){
    }
    public Person(int idNum) {
        this.idNum = idNum;
    }
    @Override
    public String toString() {
        return "Person{" +
                "idNum=" + idNum +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return idNum == person.idNum;
    }
}