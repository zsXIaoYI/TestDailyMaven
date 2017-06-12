package cn.zsza.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created by zs on 2017/6/12.
 * 18:19
 */
class Person{
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
public class ArrayListOfPerson {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1));
        personList.add(new Person(2));
        personList.add(new Person(2));
        personList.add(new Person(3));
//        System.out.println("personList="+personList);
        Iterator<Person> it = personList.iterator();
        while (it.hasNext()){
            Person per = it.next();
            System.out.println("..."+per.toString());
        }
        System.out.println(singleElement(personList));
    }
    public static List singleElement(List al) {
        List newList = new ArrayList<>();
        Iterator it = al.iterator();

        while (it.hasNext()) {
            Object obj = it.next();
            if (!newList.contains(obj)) {   // 默认会调用Person中的equals方法
                newList.add(obj);
            }
        }
        return newList;
    }
}
