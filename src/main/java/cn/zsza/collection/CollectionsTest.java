package cn.zsza.collection;

import cn.zsza.util.StrLenCom;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * Created by user on 2016/1/26.
 * 声明一个String类型的Comparator,其泛型为<String>
 */

public class CollectionsTest {

    private List<String> list;
    @Before
    public void initList(){
        list.add("ddd");
        list.add("aa");
        list.add("ab");
        list.add("ccff");
    }
    @Test
    public void testSort(){
        // 对List集合进行排序,Collections.sort()对其按照自然顺序进行排序
        Collections.sort(list);
        System.out.println("按自然顺序进行排序："+list);
        /**
         * 按长度进行排序
         */
        Collections.sort(list, new StrLenCom());
        System.out.println(list);
    }
    @Test
    public void testMax(){


        // 对List集合进行排序
        Collections.sort(list);
        System.out.println(list);
        // 发返回自然顺序最大的元素
        String maxStr = Collections.max(list);
//        maxStr = Collections.max(list,new StrLenCom());
        System.out.println("maxStr="+maxStr);
    }

    @Test
    public void testReplace(){
        /**
         * 将集合元素"aa"替换成"kk"
         */
        Collections.replaceAll(list, "aa", "kk");
        System.out.println(list);
    }

    @Test
    public void testReverse(){
        /**
         * 集合元素反转
         */
        Collections.reverse(list);
        System.out.println(list);
    }
    /**
     * Set集合默认自然升序排列
     */
    @Test
    public void testReverse2(){
        /**
         * set集合默认为降序输出
         * Collections.reverseOrder(),返回一个比较器
         * 当指定Collections.reverseOrder()时，
         */
        Set<String> set = new TreeSet<>();
//        Set<String> set = new TreeSet<>(Collections.reverseOrder());
//        Set<String> set = new TreeSet<>(Collections.reverseOrder(new StrLenCom()));

        set.add("ddaa");
        set.add("bbc");
        set.add("a");
        System.out.println("set="+set);
    }
    @Test
    public void testSwap(){
        /**
         * 把集合中位置0和1上的元素进行交换。
         */
        Collections.swap(list,0,1);
        System.out.println(list);
    }

    @Test
    public void testEmptyList(){
        /**
         * 返回的集合对象是immutable的,不可更改的
         */
        List emptyList = Collections.EMPTY_LIST;
        System.out.println("emptyList:" + emptyList);
        System.out.println("size:" + emptyList.size());
    }
}
