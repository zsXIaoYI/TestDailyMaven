package cn.zsza.spring.dao.impl;


import cn.zsza.spring.dao.PersonDao;

/**
 * Created by ZhangSong on 2016/8/12.
 */
public class PersonDaoBean implements PersonDao {


    public PersonDaoBean(){
        System.out.println("....PersonDaoBean构造方法");
    }

    public void print() {
        System.out.println("打印方法");
    }

    public String save() {
        System.out.println("save 一个 person");
        return "保存成功";
    }
}
