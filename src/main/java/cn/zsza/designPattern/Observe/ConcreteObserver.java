package cn.zsza.designPattern.Observe;

/**
 * Created by zs on 2017/8/18.
 * 10:16
 * 具体观察者角色类
 */
public class ConcreteObserver implements Observer {

    private String observerState;

    @Override
    public void update(String state) {
        // 更新观察者的状态，使其与目标的状态保持一致
        observerState = state;
        System.out.println("更新后,观察者状态为:" + observerState);

    }
}
