package cn.zsza.spring;

import cn.zsza.spring.dao.PersonDao;
import cn.zsza.spring.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created by zs on 2017/8/23.
 * 14:08
 */
public class SpringTest {
    /**
     * beans.xml中配置好bean,从xml中去拿bean
     */
    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/beans.xml");
        System.out.println("getBean方法之前");
        PersonDao personDao = (PersonDao) ctx.getBean("personDao");
        PersonDao personDao1 = (PersonDao) ctx.getBean("personDao");

        // 配置scope = prototype 返回false
        System.out.println(personDao==personDao1);
        personDao.print();
    }
    /**
     * resource注解
     * 对于service层调用dao层的业务方法,对dao的注入,交由Spring容器处理
     */
    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/Spring-resource.xml");
        PersonService personService = (PersonService) ctx.getBean("personService");
        personService.print();
    }

}
