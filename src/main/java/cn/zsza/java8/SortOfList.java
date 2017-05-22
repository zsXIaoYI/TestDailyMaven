package cn.zsza.java8;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zs on 2017/5/17.
 * 16:56
 */
public class SortOfList {
    private List<String> list = new ArrayList<>();
    @Before
    public void initList(){
        list.add("Mahesh ");
        list.add("Suresh ");
        list.add("Ramesh ");
        list.add("Naresh ");
        list.add("Kalpesh ");
    }
    @Test
    public void testUsingJava7(){
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("list java7:" + list);
    }

    /**
     * 注释中为java的实现集合元素内部排序的方式
     */
    @Test
    public void testUsingJava8(){
//        Collections.sort(list, (s1,s2) -> s1.compareTo(s2));
//        Collections.sort(list, String::compareTo);

        Collections.sort(list, Comparator.naturalOrder());
        System.out.println("list java8:" + list);
    }
}
