package cn.zsza.collection;

import cn.zsza.zs_base.entity.PP;
import org.junit.Test;
import java.util.HashSet;
import java.util.Iterator;
/**
 * Created by zs on 2017/7/25.
 * 11:58
 */
public class SetTest {
    @Test
    public void testAddPP(){
        HashSet<PP> hs = new HashSet<>();
        hs.add(new PP("A1",11));
        hs.add(new PP("A2",12));

//        hs.add(new PP("A1",11));

        Iterator<PP> it = hs.iterator();
        while (it.hasNext()){
            PP pp = it.next();
            System.out.println(pp.getName() + "...." + pp.getAge());
        }
    }
}
