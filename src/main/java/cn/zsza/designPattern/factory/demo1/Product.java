package cn.zsza.designPattern.factory.demo1;

/**
 * Created by zs on 2017/5/15.
 * 16:23
 * 也可以改成接口声明
 */
abstract class Product {
    /**
     * 声明共有的方法
     */
    public void methodSame(){
        System.out.println("product共有方法");
    }

    /**
     * 声明抽象业务方法
     */
    public abstract void methodDiff();
}
