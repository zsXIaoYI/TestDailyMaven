package cn.zsza.designPattern.decorator.demo1;

/**
 * Created by zs on 2017/8/9.
 * 17:48
 */
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        super.operate();

        System.out.println("ConcreteDecoratorA.....");
    }
}
