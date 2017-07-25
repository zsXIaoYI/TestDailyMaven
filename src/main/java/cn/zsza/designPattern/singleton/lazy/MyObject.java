package cn.zsza.designPattern.singleton.lazy;

/**
 * Created by zs on 2017/7/25.
 * 16:34
 * 懒汉式
 */
public class MyObject {
    private static MyObject myObject;

    private MyObject(){}

    public static MyObject getInstance(){
        try {
            if (myObject != null){

            }else {
                Thread.sleep(3000);
                synchronized (MyObject.class){
                    if (myObject == null)
                        myObject = new MyObject();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
