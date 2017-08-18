package cn.zsza.designPattern.Observe;

/**
 * Created by zs on 2017/8/18.
 * 10:24
 */
public class ObserverClient {
    public static void main(String[] args) {
        // 创建主题对象
        ConcreteSubject subject = new ConcreteSubject();

        // 创建观察者对象
        Observer observer = new ConcreteObserver();
        subject.attach(observer);

        // 改变主题对象状态
        subject.change("new new state");
    }
}
