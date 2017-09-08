package cn.zsza.map;

import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by ZhangSong on 2017/9/8.
 * 21:16
 */
public class ConcurrentHashMapTest {
    private Map<String,String> map = new ConcurrentHashMap<>();

    @Before
    public void  init(){
        map.put("1","~1");
        map.put("2","~2");
    }
    /**
     * 下面map返回{1=1~1, 2=~2}
     * BiFunction拿到key,然后对key + value进行拼接操作
     *
     * 如果key不存在
     *  map.compute("A",bi);
     *  返回:{1=~1, A=Anull, 2=~2}
     */
    @Test
    public void testCompute(){
        BiFunction<String,String,String> bi = (x, y) -> x + y;
//        map.compute("1",bi);
        map.compute("A",bi);
        System.out.println(map);
    }
    /**
     * map返回{1=~1, 2=~2, 3=3dy}
     */
    @Test
    public void testComputeIfAbsent(){
        String  y = "dy";
        Function<String,String> fc = x -> x + y;
        String res = map.computeIfAbsent("3", fc);
        System.out.println(map);
        System.out.println(res);
    }
}
