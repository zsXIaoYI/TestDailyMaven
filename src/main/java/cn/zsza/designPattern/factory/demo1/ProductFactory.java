package cn.zsza.designPattern.factory.demo1;

/**
 * Created by zs on 2017/5/15.
 * 16:29
 */
public class ProductFactory {
    /**
     * 静态工厂方法创建实例
     * @param type
     * @return
     */
    public  static Product getProInstance(String type){
        Product product = null;
        if ("A".equals(type)){
            product = new ConcreteProductA();
        }else if ("B".equals(type)){
            product = new ConcreteProductB();
        }
        return product;
    }
}
