package cn.zsza.designPattern.strategy.demo1;

/**
 * Created by zs on 2017/8/17.
 * 14:19
 * 具体策略者A
 */
public class ConcreteStrategyA implements Strategy {
    @Override
    public void strategyInterface() {
        System.out.println(".......ConcreteStrategyA");
    }
}
