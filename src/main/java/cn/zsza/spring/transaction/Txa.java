package cn.zsza.spring.transaction;

/**
 * Created by ZhangSong on 2017/8/27.
 * 11:26
 */
public class Txa {

    public void beginTransaction(){
        System.out.println("开始事务");
    }

    public void commit(){
        System.out.println("提交事务");
    }
}
