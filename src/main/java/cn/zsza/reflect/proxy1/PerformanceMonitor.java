package cn.zsza.reflect.proxy1;

/**
 * Created by zs on 2017/5/16.
 * 18:38
 */
public class PerformanceMonitor {

    private static ThreadLocal<MethodPerformance> performanceRecord =
            new ThreadLocal<>();

    public static void begin(String method){
        System.out.println("begin monitor....");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecord.set(mp);
    }

    public static void end(){
        System.out.println("end monitor...");
        MethodPerformance mp = performanceRecord.get();
        mp.printPerformance();
    }

}
