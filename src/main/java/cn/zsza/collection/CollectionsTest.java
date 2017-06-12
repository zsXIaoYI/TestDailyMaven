package cn.zsza.collection;

import org.junit.Test;
import java.util.*;
/**
 * Created by user on 2016/1/26.
 * 声明一个String类型的Comparator,其泛型为<String>
 */
class StrLenCom implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()){
            return 1;
        }
        if (o1.length() < o2.length()){
            return -1;
        }
        return o1.compareTo(o2);
    }
}
public class CollectionsTest {
    @Test
    public void testSort(){
        List<String> list = new ArrayList<>();
        list.add("ddd");
        list.add("a");
        list.add("ab");
        list.add("ccff");

        System.out.println("初始化的list:"+list);
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
        List<String> list = new ArrayList<>();
        list.add("ddd");
        list.add("a");
        list.add("ab");
        list.add("ccff");
        list.add("zs");

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
        List<String> list = new ArrayList<>();
        list.add("ddd");
        list.add("aa");
        list.add("ab");
        list.add("ccff");
        /**
         * 将集合元素"aa"替换成"kk"
         */
        Collections.replaceAll(list, "aa", "kk");
        System.out.println(list);
    }

    @Test
    public void testReverse(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
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
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        /**
         * 把集合中位置0和1上的元素进行交换。
         */
        Collections.swap(list,0,1);
        System.out.println(list);
    }
}
