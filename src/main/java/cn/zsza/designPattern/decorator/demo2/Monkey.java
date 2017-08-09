package cn.zsza.designPattern.decorator.demo2;

/**
 * Created by zs on 2017/8/9.
 * 18:04
 */
// 具体构件角色“大圣本尊”猢狲类
public class Monkey implements TheGreatestSage {
    @Override
    public void move() {
        System.out.println("Monkey Move");
    }
}
