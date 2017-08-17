package cn.zsza.designPattern.strategy.demo1;

/**
 * Created by zs on 2017/8/17.
 * 14:15
 */
public class Context {
    // 持有一个具体策略的对象
    private Strategy strategy;

    /**
     * 构造方法
     * @param strategy
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 策略方法
     */
    public void contextInterface(){
        strategy.strategyInterface();
    }


}
