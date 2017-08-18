package cn.zsza.designPattern.Observe;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by zs on 2017/8/18.
 * 10:18
 * 抽象主题角色类
 */
public abstract class Subject {

    /**
     * 用来保存注册的观察者对象
     */
    private List<Observer> list = new ArrayList<>();

    /**
     * 注册观察者对象
     * @param observer 观察者对象
     */
    public void attach(Observer observer){
        list.add(observer);
        System.out.println("Attached an observer");
    }

    /**
     *  删除观察者对象
     * @param observer  观察者对象
     */
    public void detach(Observer observer){

        list.remove(observer);
    }

    /**
     * 通知所有注册的观察者对象
     * @param newState
     */
    public void nodifyObservers(String newState){
        list.forEach(e -> e.update(newState));
    }


}
