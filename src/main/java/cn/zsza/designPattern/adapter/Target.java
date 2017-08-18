package cn.zsza.designPattern.adapter;

/**
 * Created by zs on 2017/8/18.
 * 9:58
 * 目标(Target)角色
 */
public interface Target {


    /**
     * 这是源类Adaptee也有的方法
     */
    public void sampleOperation1();


    /**
     * 这是源类Adapteee没有的方法
     */
    public void sampleOperation2();
}
