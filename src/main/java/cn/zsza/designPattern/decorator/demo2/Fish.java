package cn.zsza.designPattern.decorator.demo2;

/**
 * Created by zs on 2017/8/9.
 * 18:08
 */
public class Fish extends Change {
    public Fish(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Fish Move");
    }
}
