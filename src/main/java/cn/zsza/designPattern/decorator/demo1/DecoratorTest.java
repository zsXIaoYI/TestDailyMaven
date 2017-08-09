package cn.zsza.designPattern.decorator.demo1;

/**
 * Created by zs on 2017/8/9.
 * 17:51
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();

        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(component);

        decoratorA.operate();
    }
}
