package cn.zsza.dataStructure.LRU;

import java.util.HashMap;
/**
 * Created by zs on 2017/7/26.
 * 15:19
 * 基于HashMap实现的LRU算法
 */
public class LRUCachel<K,V> {
    /**
     * 对于final修饰的成员变量,要么初始化,要么在构造方法中初始化
     */
    private final int MAX_CACHE_SIZE;
    private Entry first;
    private Entry last;

    private HashMap<K,Entry<K,V>> hashMap;

    public LRUCachel(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        hashMap = new HashMap<>();
    }

    public void put(K key, V value){
        Entry entry = getEntry(key);
        if (entry == null){
            if (hashMap.size() >= MAX_CACHE_SIZE){
                hashMap.remove(last.key);
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        hashMap.put(key,entry);
    }

    public V get(K key){
        Entry<K,V> entry = getEntry(key);
        if (entry == null) return null;
        moveToFirst(entry);

        return entry.value;
    }

    public void remove(K key){
        Entry entry = getEntry(key);
        if (entry != null){
            if (entry.pre != null) entry.pre.next = entry.next;
            if (entry.next != null) entry.next.pre = entry.pre;
            if (entry == first) first = entry.next;
            if (entry == last) last = entry.pre;
        }
        hashMap.remove(key);
    }

    public void moveToFirst(Entry entry) {
        if (entry == null) return;
        if (entry.pre != null) entry.pre.next = entry.next;
        if (entry.next != null) entry.next.pre = entry.pre;
        if (entry == last) last = last.pre;

        if (first == null || last == null){
            first = last = entry;
            return;
        }
        /**
         * 当添加第二个节点时..........
         * 当前节点.next = first
         * first.pre = 当前节点
         * first = 当前节点
         * 当前节点.pre = null
         */
        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;

    }


    private void removeLast() {
        if (last != null){
            last = last.pre;
            if (last == null) first = null;
            else last.next = null;
        }
    }

    private Entry<K,V> getEntry(K key) {
        return hashMap.get(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Entry entry = first;

        while (entry != null){
            sb.append(String.format("%s:%s\n", entry.key,entry.value));
            entry = entry.next;
        }

        return sb.toString();
    }

    static class Entry<K,V> {
        public Entry pre;
        public Entry next;
        public K key;
        public V value;
    }

    public static void main(String[] args) {
        LRUCachel<String,String> lruCachel = new LRUCachel<>(3);

        for (int i = 0; i < 5; i++){
            lruCachel.put(i + "","小" + i);
        }

        System.out.println(lruCachel);

        Entry<String, String> entry = lruCachel.getEntry("3");
        System.out.println("entry:" +entry);

        lruCachel.moveToFirst(entry);

        System.out.println(lruCachel);


    }
}
