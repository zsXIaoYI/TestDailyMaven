package cn.zsza.designPattern.prototype;

/**
 * Created by zs on 2017/7/20.
 * 18:09
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape shape1 = ShapeCache.getShape("1");
        System.out.println("Shape : " + shape1.getType());
    }
}
