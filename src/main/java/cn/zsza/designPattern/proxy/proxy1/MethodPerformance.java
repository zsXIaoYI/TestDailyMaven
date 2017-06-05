package cn.zsza.designPattern.proxy.proxy1;

/**
 * Created by zs on 2017/5/16.
 * 18:32
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    /**
     * 监控执行时间
     */
    public void printPerformance(){
        end = System.currentTimeMillis();
        long elapse = end - begin;

        System.out.println(serviceMethod + "执行花费" + elapse + "毫秒");
    }

}
