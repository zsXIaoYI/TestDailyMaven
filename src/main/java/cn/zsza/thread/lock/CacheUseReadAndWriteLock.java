package cn.zsza.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * Created by ZhangSong on 2017/9/24.
 * 17:46
 */
public class CacheUseReadAndWriteLock {
    private static Map<String,Object> map = new HashMap<>();
    private static ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();

    private static Lock r = rw1.readLock();   // 读锁
    private static Lock w = rw1.writeLock();  // 写锁

    public static final Object get(String key){
        r.lock();
        try{
            return map.get(key);
        }finally {
            r.unlock();
        }
    }
    /**
     * 当获取写锁后，其他线程对于读锁和写锁的获取均被阻塞，而只有写锁释放之后，其他
     * 读写才能继续
     * @param key
     * @param value
     * @return
     */
    public static final Object put(String key, Object value){
        w.lock();
        try {
            return map.put(key, value);
        }finally {
            w.unlock();
        }
    }
    // 清空所有的内容
    public static final void clear(){
        w.lock();
        try{
            map.clear();
        }finally {
            w.unlock();
        }
    }
}
