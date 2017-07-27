package cn.zsza.jvm;

/**
 * Created by zs on 2017/7/27.
 * 15:11
 * 栈内存溢出
 */
public class StackOverFlowTest {

    public void stackOverFlowMethod(){
        stackOverFlowMethod();
    }

    public static void main(String[] args) {
        new StackOverFlowTest().stackOverFlowMethod();
    }
}
