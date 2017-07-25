package cn.zsza.collection;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
/**
 * Created by zs on 2017/6/12.
 * 18:16
 */
public class ListTest {
    private List<String> parentList;
    Logger logger = Logger.getLogger(ListTest.class);
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

    /**
     * List特有的迭代器ListIterator,该迭代器在迭代的同时，可以添加、删除、修改，而Iterator则会报
     * 会报java.util.ConcurrentModificationException
     */
    @Test
    public void testListIterator(){
        ListIterator<String> iterator = parentList.listIterator();

        while (iterator.hasNext()){
            String obj = iterator.next();
            System.out.println("obj:" + obj);
            logger.info("res obj:" + obj);
        }

        while (iterator.hasPrevious())
            System.out.println("逆向遍历:" + iterator.previous());
    }

    /**
     * asList 接受的参数是一个泛型的变长参数，我们知道基本数据类型是无法发型化的，也就是说 8 个基本类型是无法作为 asList 的参数的，
     * 要想作为泛型参数就必须使用其所对应的包装类型
     */
    @Test
    public void testArrays(){
        int a1[] = new int[]{1,2,3};
        Integer a2[]  = new Integer[]{1,2,3};
        String a3[] = new String[]{"a","b","c"};

        System.out.println(Arrays.asList(a1));
        System.out.println(Arrays.asList(a2));
        System.out.println(Arrays.asList(a3));

    }
    @Test
    public void testRead() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("D:\\WorkSpace_new\\IDEA\\TestDailyMaven\\pom.xml")),
                StandardCharsets.UTF_8);

        List<String> list = Arrays.asList(contents.split("\n"));
//        System.out.println(contents);
        System.out.println(list.size());

    }
}
