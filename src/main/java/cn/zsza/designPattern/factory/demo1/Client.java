package cn.zsza.designPattern.factory.demo1;

/**
 * Created by zs on 2017/5/15.
 * 16:39
 */
public class Client {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Product product = ProductFactory.getProInstance("A");
        product.methodSame();
        product.methodDiff();


        Class<?> client = Class.forName("cn.zsza.designPattern.factory.demo1.Client");
        Object obj = client.newInstance();
        System.out.println("obj:" +obj);


    }
}
