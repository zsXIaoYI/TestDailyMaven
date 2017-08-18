package cn.zsza.designPattern.Observe;

import lombok.Data;

/**
 * Created by zs on 2017/8/18.
 * 10:24
 * 具体主题角色类
 */
@Data
public class ConcreteSubject extends Subject {
    private String state;

    public void  change(String newState){
        state = newState;
        System.out.println("主题状态为:" + state);
        this.nodifyObservers(state);
    }
}
