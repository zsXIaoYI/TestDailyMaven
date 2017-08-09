package cn.zsza.designPattern.decorator.demo1;

/**
 * Created by zs on 2017/8/9.
 * 17:47
 */
public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
        component.operate();
    }
}
