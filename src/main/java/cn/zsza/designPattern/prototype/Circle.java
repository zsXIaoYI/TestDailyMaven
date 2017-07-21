package cn.zsza.designPattern.prototype;

/**
 * Created by zs on 2017/7/20.
 * 17:59
 */
public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
