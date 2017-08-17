package cn.zsza.designPattern.proxy.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ZhangSong on 2017/8/17.
 * 21:27
 */
public class RPCProxyClient implements InvocationHandler {

    private Object obj;

    public RPCProxyClient(Object obj) {
        this.obj = obj;
    }

    public static Object getProxy(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),new RPCProxyClient(obj));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(obj,args);
        return result;
    }
}
