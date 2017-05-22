package cn.zsza.reflect.proxy2;

import cn.zsza.reflect.proxy1.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**通过Cglib创建动态代理
 * Created by zs on 2017/5/18.
 * 10:42
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){  // 需要被创建代理类的字节码
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable {
        PerformanceMonitor.begin(obj.getClass().getName() + "...." + method.getName());
        Object result = methodProxy.invokeSuper(obj,args);
        PerformanceMonitor.end();
        return result;
    }
}
