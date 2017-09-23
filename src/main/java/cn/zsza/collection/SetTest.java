package cn.zsza.collection;

import cn.zsza.util.UUComparator;
import cn.zsza.zs_base.entity.PP;
import cn.zsza.zs_base.entity.UU;
import org.junit.Test;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**
 * Created by zs on 2017/7/25.
 * 11:58
 * Set集合无需，不可重复
 */
public class SetTest {
    @Test
    public void testAddPP(){
        HashSet<PP> hs = new HashSet<>();
        hs.add(new PP("A1",11));
        hs.add(new PP("A2",12));


        Iterator<PP> it = hs.iterator();
        while (it.hasNext()){
            PP pp = it.next();
            System.out.println(pp.getName() + "...." + pp.getAge());
        }
    }
    @Test
    public void testTreeSetUU(){
        /**
         * TreeSet构造方法可以接受一个比较器
         */
        Set<UU> uuSet = new TreeSet<>(new UUComparator());
        uuSet.add(new UU(10,"001"));
        uuSet.add(new UU(8,"003"));
        uuSet.add(new UU(12,"006"));
        uuSet.add(new UU(12,"006"));
        uuSet.add(new UU(18,"005"));
        uuSet.add(new UU(7,"008"));

        uuSet.forEach(e -> System.out.println(e.getAge() + "..." + e.getName()));
    }

}
