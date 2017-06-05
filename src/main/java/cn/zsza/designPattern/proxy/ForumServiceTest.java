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
 * JDK活CGLib的缺点:
 *  1).目标类的所有方法都添加了性能监视横切逻辑,而有时这时并不是我们所期望的,
 * 我们可能只希望对业务类中的某些特定方法添加横切逻辑.
 *  2).通过硬编码的方式指定了织入横切逻辑的织入点,即在目标类业务方法的开始和结束
 * 前织入代码。
 *  3).手工编写代理实例的创建过程,在为不同类创建代理时,需要分别编写相应的创建代码,
 * 无法做到通用
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
