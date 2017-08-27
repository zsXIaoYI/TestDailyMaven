package cn.zsza.spring.interceptor;

import org.aspectj.lang.annotation.*;
/**
 * Created by ZhangSong on 2017/8/27.
 * 13:50
 * 切面交给Spring管理
 */
@Aspect
public class MyInterceptor {
    /**
     * 切入点：@Pointcut("execution (* cn.zsza.service.impl..*.*(..))")
     * 执行业务方法进行拦截
     * “*” 任何返回值类型 “..”该包以及所有子包，“*”所有class,"*"所有方法 ".."方法参数任意
     */
    @Pointcut("execution (* cn.zsza.spring.aspect.PersonServiceBean.*(..))")
    private void anyMethod(){    // 声明一个切入点
    }

//    @Before("anyMethod()")
//    public void doAccessCheck(){
//        System.out.println("无参前置通知");
//    }

    /**
     * 前置通知
     * @param name 拦截所有有且只有一个字符串参数的方法
     */
    @Before("anyMethod() && args(name)")
    public void doAccessCheck(String name){
        System.out.println("前置通知:"+name);
    }

    /**
     * 该通知在AfterReturning通知之前执行
     */

    @After("anyMethod()")
    public void doAfter(){
        System.out.println("后置通知");
    }

    /**
     * 后置通知
     */
    @AfterReturning("anyMethod()")
    public void doAfterReturn(){
        System.out.println("最终通知");
    }


    /**
     * 例外通知
     * 出现例外通知时，后置通知不会执行
     * @param e
     */
    @AfterThrowing(pointcut = "anyMethod()",throwing = "e")
    public void doAfterThrowing(Exception e){
        System.out.println("例外通知："+ e);
    }



}
