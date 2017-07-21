package cn.zsza.designPattern.prototype;

/**
 * Created by zs on 2017/7/20.
 * 17:59
 */
public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
