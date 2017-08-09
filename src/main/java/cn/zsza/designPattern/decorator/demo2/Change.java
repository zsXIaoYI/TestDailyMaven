package cn.zsza.designPattern.decorator.demo2;

/**
 * Created by zs on 2017/8/9.
 * 18:05
 */
// 抽象装饰角色“七十二变”
public class Change implements TheGreatestSage {
    private TheGreatestSage sage;

    public Change(TheGreatestSage sage) {
        this.sage = sage;
    }

    @Override
    public void move() {
        sage.move();
    }
}
