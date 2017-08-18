package cn.zsza.designPattern.Observe;

/**
 * Created by zs on 2017/8/18.
 * 10:15
 * 抽象观察者角色类
 */
public interface Observer {

    /**
     * 定义一个更新方法
     * @param state
     */
    public void update(String state);
}
