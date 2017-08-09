package cn.zsza.designPattern.decorator.demo1;

/**
 * Created by zs on 2017/8/9.
 * 17:45
 */
public class ConcreteComponent implements Component {
    @Override
    public void operate() {
        System.out.println("ConcreteComponent.....");
    }
}
