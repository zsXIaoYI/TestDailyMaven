package cn.zsza.spring.service.impl;

import cn.zsza.spring.dao.PersonDao;
import cn.zsza.spring.service.PersonService;
import javax.annotation.Resource;
/**
 * Created by ZhangSong on 2016/8/12.
 */
public class PersonServiceBean implements PersonService {
    /**
     * 去Spring容器中查找名字为:personDaoXX的bean
     */
    @Resource(name = "personDaoXX")
    private PersonDao personDao;

    public void print() {
        System.out.println("PersonServiceBean");
        personDao.print();
    }
}
