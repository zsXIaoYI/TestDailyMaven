package cn.zsza.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zs on 2017/6/5.
 * 17:54
 */
public class SynchronizedMap {
    /**
     * 生成一个线程安全的Map
     */
    private Map<String,Object> map = Collections.synchronizedMap(new HashMap<>());
}
