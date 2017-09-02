package cn.zsza.spring;

import cn.zsza.spring.aspect.PersonService;
import cn.zsza.spring.dao.PersonDao;
import cn.zsza.spring.entity.Person;
import cn.zsza.spring.jdbc.PersonServiceBean_jdbc;
import cn.zsza.spring.jdbc.PersonService_jdbc;
import cn.zsza.spring.jdbc.TestTxa;
import cn.zsza.spring.service.UserService;
import cn.zsza.spring.zs.ZSClassPathXMLApplicationContext;
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
        PersonDao personDao = (PersonDao) ctx.getBean("personDao");
        PersonDao personDao1 = (PersonDao) ctx.getBean("personDao");

        // 配置scope = prototype 返回false
        System.out.println(personDao==personDao1);
        personDao.print();
    }
    /**
     * <content:annotation-config/>
     * resource注解
     * 对于service层调用dao层的业务方法,对dao的注入,交由Spring容器处理
     */
    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/Spring-resource.xml");
        cn.zsza.spring.service.PersonService personService = (cn.zsza.spring.service.PersonService) ctx.getBean("personService");
        personService.print();
    }

    /**
     * resource注解,基于包的自动扫描
     * <content:component-scan/>
     */
    @Test
    public void test3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/Spring-resource-component-scan.xml");
        UserService userService = (UserService) ctx.getBean("userServiceImpl");
        userService.testMethod();
    }


    @Test
    public void testAOP(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/Spring-aop.xml");
        PersonDao personDao = (PersonDao) ctx.getBean("personDao");
        personDao.print();
    }
    @Test
    public void testAOP2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/Spring-aop-aspect.xml");
        PersonService personService = (PersonService) ctx.getBean("personService");
        // 只有一个String类型参数的前置通知被执行
        personService.save("小A");

    }
    @Test
    public void testMyBeanXML(){
        ZSClassPathXMLApplicationContext ctx = new ZSClassPathXMLApplicationContext("Spring/Spring-ref.xml");
    }
    //************************JDBC************************
    @Test
    public void testSave(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/Spring-config-jdbc.xml");
        PersonService_jdbc personService_jdbc = (PersonService_jdbc) ctx.getBean("personServiceBean");
        personService_jdbc.save(new Person("小A"));
    }

    @Test
    public void testDelete() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/Spring-config-jdbc.xml");
        PersonService_jdbc personService_jdbc = (PersonService_jdbc) ctx.getBean("personServiceBean");
        personService_jdbc.deletePerson(4);

    }

    @Test
    public void testTxaNever() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/Spring-config-jdbc.xml");
        TestTxa testTxa = (TestTxa) ctx.getBean("testTxa");
        testTxa.testNever(10);
    }

    @Test
    public void testMANDATORY() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/Spring-config-jdbc.xml");
        TestTxa testTxa = (TestTxa) ctx.getBean("testTxa");
        testTxa.testMANDATORY(11);
    }
    @Test
    public void testNESTED() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/Spring/Spring-config-jdbc.xml");
        TestTxa testTxa = (TestTxa) ctx.getBean("testTxa");
        testTxa.testNESTED(12,new Person("小B"));
    }
}
