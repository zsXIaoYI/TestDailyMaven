package cn.zsza.designPattern.proxy.rpc;

/**
 * Created by ZhangSong on 2017/8/17.
 * 21:34
 */
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String sayHello(String msg) {
        String result = "hello " + msg;
        System.out.println(result);
        return result;
    }
}
