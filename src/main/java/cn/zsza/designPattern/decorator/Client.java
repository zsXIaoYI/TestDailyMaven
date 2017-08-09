package cn.zsza.designPattern.decorator;

import cn.zsza.designPattern.decorator.demo1.Component;
import cn.zsza.designPattern.decorator.demo1.ConcreteComponent;
import cn.zsza.designPattern.decorator.demo1.ConcreteDecoratorA;
import cn.zsza.designPattern.decorator.demo2.Fish;
import cn.zsza.designPattern.decorator.demo2.Monkey;
import cn.zsza.designPattern.decorator.demo2.TheGreatestSage;
import org.junit.Test;

/**
 * Created by zs on 2017/8/9.
 * 18:09
 */
public class Client {
    @Test
    public void test1(){
        Component component = new ConcreteComponent();

        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(component);

        decoratorA.operate();
    }
    @Test
    public void test2(){
        TheGreatestSage sage = new Monkey();

        TheGreatestSage fish = new Fish(sage);

        fish.move();
    }
}
