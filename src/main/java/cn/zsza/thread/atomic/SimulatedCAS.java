package cn.zsza.thread.atomic;

/**
 * Created by zs on 2017/8/31.
 * 15:12
 * 解释CAS实现过程
 */
public class SimulatedCAS {
    private int value;

    public SimulatedCAS(int value) {
        this.value = value;
    }

    public synchronized int getValue(){
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue){
        int oldValue = value;
        if (value == expectedValue)
            value = newValue;
        return oldValue;
    }
}

