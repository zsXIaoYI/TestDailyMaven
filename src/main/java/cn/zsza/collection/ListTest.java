package cn.zsza.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zs on 2017/6/12.
 * 18:16
 */
public class ListTest {
    private List<String> parentList;
    @Before
    public void init(){
        parentList = new ArrayList<>();
        parentList.add("0");
        parentList.add("1");
        parentList.add("2");
        parentList.add("3");
        parentList.add("4");
    }

    @Test
    public void testSet(){
        System.out.println("init parentList:" + parentList);
        /**
         * 把1号元素的位置上的元素用新的元素代替
         */
        parentList.set(1,"new 1");

        System.out.println("after set parentList:" + parentList);
    }


    @Test
    public void testSubList(){
        List<String> subList = parentList.subList(1, 3);
        System.out.println("subList:" + subList);

        subList.set(0,"new 1");
//        parentList.stream().forEach(System.out::println);  // 0,new 1,2,3,4
        subList.add("2.5");

        System.out.println("subList:" + subList);
        System.out.println("parentList:" + parentList);

        parentList.set(2,"new 2");
        System.out.println("after set parentList:" + parentList);

        /**
         * 修改了原有list的结构
         */
        parentList.add("undefine");
        parentList.stream().forEach(System.out::println);
        System.out.println("subList get:" + subList.get(0));


    }
}
