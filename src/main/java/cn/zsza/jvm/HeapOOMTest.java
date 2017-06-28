package cn.zsza.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zs on 2017/6/27.
 * 18:51
 * 模拟堆内存溢出
 * jvm参数:
 * -Xmn10M
 * -Xms20M
 * -Xmx20M
 * -XX:+PrintGCDetails
 */
public class HeapOOMTest {

    public static void main(String[] args) {
        List<byte[]> buffer = new ArrayList<>();
        buffer.add(new byte[10*1024*1024]);

        System.out.println(buffer.size());
    }
}
