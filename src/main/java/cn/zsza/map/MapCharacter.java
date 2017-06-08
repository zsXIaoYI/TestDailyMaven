package cn.zsza.map;

/**
 * Created by user on 2016/1/20.
 */

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Map集合：数据之间存在着某种关系
 * Map实现字符串中，字符在字符串中出现的次数
 */
public class MapCharacter {
    /**
     * 字符串中字符出现的次数
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(charCount("aaabbc"));
    }

    public static String charCount(String str){
        char chs[] = str.toCharArray();    // 字符串转换成字符数组

        TreeMap<Character,Integer> tm = new TreeMap<>();
        int count = 0;
        for (int x = 0;x < chs.length; x++){
            if (!(chs[x] >= 'a'&& chs[x] < 'z'|| chs[x] >= 'A'&& chs[x] < 'Z'))
                continue;
            Integer value = tm.get(chs[x]);
//            if (value == null){     // 如果Map中返回的字母出现的次数为null
//               tm.put(chs[x],1);
//            }else {
//                tm.put(chs[x],value + 1);
//            }
            //对上面注释的代码优化
            if (value != null){    // 如果不空，代表map中已存入该字母
                count = value;     // value代表存入的字符的个数
            }
            count++;
            tm.put(chs[x],count);

            count = 0;   // 遍历一个字母，清零一次
        }
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Character,Integer>> entrySet = tm.entrySet();
        Iterator<Map.Entry<Character,Integer>> it = entrySet.iterator();
        while (it.hasNext()){
            Map.Entry<Character,Integer> me = it.next();
            Character ch = me.getKey();
            Integer value = me.getValue();
            sb.append(ch + "("+value + ")");

        }
        return sb.toString();
    }
}
