package cn.zsza.thread.atomic;

/**
 * Created by zs on 2017/8/31.
 * 15:16
 */
public class CasCounter {
    private static final SimulatedCAS CAS = new SimulatedCAS(1);


    public int getValue(){
        return CAS.getValue();
    }

    public int increment(){
        int oldValue = CAS.getValue();
        while (CAS.compareAndSwap(oldValue,oldValue + 1) != oldValue)
            oldValue = CAS.getValue();
        return oldValue + 1;
    }

    public static void main(String[] args) {
        CasCounter cas = new CasCounter();
        System.out.println(cas.increment());
    }
}
