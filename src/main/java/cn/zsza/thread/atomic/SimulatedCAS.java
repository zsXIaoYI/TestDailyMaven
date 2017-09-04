package cn.zsza.thread.atomic;

/**
 * Created by zs on 2017/8/31.
 * 15:16
 * Compare and swap(CAS)
 * 当前的处理器基本都支持CAS，只不过每个厂家所实现的算法并不一样罢了，每一个CAS操作过程都包含三个运算符：一个内存地址V，一个期望的值A
 * 和一个新值B，操作的时候如果这个地址上存放的值等于这个期望的值A，则将地址上的值赋为新值B，否则不做任何操作。CAS的基本思路就是，
 * 如果这个地址上的值和期望的值相等，则给其赋予新值，否则不做任何事儿，但是要返回原值是多少
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

