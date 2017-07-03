package cn.zsza.designPattern.proxy;

import cn.zsza.designPattern.proxy.proxy1.ForumService;
import cn.zsza.designPattern.proxy.proxy1.ForumServiceImpl;
import cn.zsza.designPattern.proxy.proxy1.PerformanceHandler;
import cn.zsza.designPattern.proxy.proxy2.CglibProxy;
import org.junit.Test;
import java.lang.reflect.Proxy;
/**
 * Created by zs on 2017/5/16.
 * 18:44
 * Spring AOP的底层是通过使用JDK或CGLib动态代理技术为目标Bean织入横切
 * 逻辑的。
 * JDK或CGLib的缺点:
 *  1).目标类的所有方法都添加了性能监视横切逻辑,而有时这时并不是我们所期望的,
 * 我们可能只希望对业务类中的某些特定方法添加横切逻辑.
 *  2).通过硬编码的方式指定了织入横切逻辑的织入点,即在目标类业务方法的开始和结束
 * 前织入代码。
 *  3).手工编写代理实例的创建过程,在为不同类创建代理时,需要分别编写相应的创建代码,
 * 无法做到通用
 *
 * 二者性能比较:
 *  CGLLib所创建的动态代理对象的性能依旧比JDK所创建的动态代理对象性能高不少（大概10倍）
 *  但CGLib在创建代理对象时所花费的时间却比JDK动态代理多（大概8倍）
 *  对于singleton的代理对象或者具有实例池的代理,因此无须频繁地创建代理对象,所以比较适合采用
 *  CGLib动态代理技术;反之则适合采用JDK动态代理技术
 */
public class ForumServiceTest {
    /**
     * jdk实现动态代理
     */
    @Test
    public void jdkProxy(){
        ForumService target = new ForumServiceImpl();

        PerformanceHandler handler = new PerformanceHandler(target);

        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);

        proxy.removeTopic(20);
        System.out.println();
        proxy.removeForum(10);
    }

    /**
     * Cglib实现的动态代理
     */
    @Test
    public void cglibProxy(){
        CglibProxy proxy = new CglibProxy();
        ForumService forumService = (ForumService) proxy.getProxy(ForumServiceImpl.class);

        forumService.removeForum(10);
    }
}
