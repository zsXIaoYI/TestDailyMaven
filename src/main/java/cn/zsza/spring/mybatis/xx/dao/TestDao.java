package cn.zsza.spring.mybatis.xx.dao;

import cn.zsza.spring.mybatis.xx.entity.Test;

import java.util.List;

/**
 * Created by zhangsong on 2017/10/26.
 */
public interface TestDao {

    public List<Test> selectList();
}
