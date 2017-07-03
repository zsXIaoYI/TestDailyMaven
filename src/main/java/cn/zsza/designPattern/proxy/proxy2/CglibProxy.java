package cn.zsza.designPattern.proxy.proxy2;

import cn.zsza.designPattern.proxy.proxy1.PerformanceMonitor;
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

    /**
     *
     * @param obj
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     * obj表示目标类的实例,method为目标类方法的反射对象,args为方法的动态入参,methodProxy为代理类的实例
     * 由于CGLib采用动态创建子类的方法生成代理对象,所以不能对目标类中的final或private方法进行代理
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable {
        PerformanceMonitor.begin(obj.getClass().getName() + "...." + method.getName());
        Object result = methodProxy.invokeSuper(obj,args);
        PerformanceMonitor.end();
        return result;
    }
}
