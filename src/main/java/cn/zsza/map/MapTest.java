package cn.zsza.map;

import org.junit.Test;
import java.util.*;

/**
 * Created by zs on 2017/6/8.
 * 16:51
 */
public class MapTest {
    @Test
    public void test1(){
        Map<String,String> map = new HashMap<>();
        map.put("01","小一");
        map.put("02","小二");
        map.put("03","小三");
        System.out.println(map);
        //1.判断是否包含某个键，返回true或false
        map.containsKey("01");
        // 2. 移除某个键，如果键不存在，返回null;存在,则返回键所对应的值
        map.remove("02");
        // 3. 返回所有键的值：map.values();
        map.values();
        // 4. 返回所有的键
        Set<String> set = map.keySet();
        Iterator<String> ss = set.iterator();
        while (ss.hasNext()) {
            String key = ss.next();
            System.out.println("key:" + key);
        }
        for (String str:set){
            System.out.println(str+"...."+map.get(str));
        }
    }

    /**
     * 通过Map.Entry迭代Map
     */
    @Test
    public void  testEntrySet(){
        Map<String,String> map = new TreeMap<>();
        map.put("02","小二");
        map.put("01", "小一");
        map.put("03", "小三");
        /**
         *  Map.Entry<String,String>对象
         *
         */
        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String,String>> it = entrySet.iterator();
        while (it.hasNext()){
            Map.Entry<String,String> me = it.next();
            String key = me.getKey();
            String value = me.getValue();
            System.out.println(key+"...."+value);
        }
    }

    /**
     * HashMap支持null作为键
     */
    @Test
    public void nullHashMap(){
        Map<String,String> map = new HashMap<>();
        map.put("02","小二");
        map.put("01", "小一");
        map.put("03", "小三");
        map.put(null, "小空");     // HashMap允许null，作为键

        Set<String> set = map.keySet();
        Iterator<String> ss = set.iterator();
        while (ss.hasNext()) {
            String key = ss.next();
            String value = map.get(key);
            System.out.println("key= "+key+"...value="+value);
        }
    }

    /**
     * HashTable支持枚举
     */
    @Test
    public void testHashtable(){
        Hashtable<String,String> hashtable = new Hashtable<>();
        hashtable.put("1","aa");
        hashtable.put("3","cc");
        hashtable.put("2", "bb");
        System.out.println("hashtable=" + hashtable);
        Enumeration<String> ele = hashtable.keys();    // 返回所有的键
        while (ele.hasMoreElements()){
            String key = ele.nextElement();
            String value = hashtable.get(key);
            System.out.println("...key="+ key + "...value="+value);
        }
    }

}