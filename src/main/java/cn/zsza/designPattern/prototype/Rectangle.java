package cn.zsza.designPattern.prototype;

/**
 * Created by zs on 2017/7/20.
 * 17:57
 */
public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
