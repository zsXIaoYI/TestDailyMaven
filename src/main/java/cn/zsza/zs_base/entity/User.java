package cn.zsza.zs_base.entity;

import lombok.Data;

/**
 * Created by zs on 2017/7/4.
 * 18:37
 */
@Data
public class User {
    private int id;
    private String name;
    private String from;

    public User(int id, String name,String from) {
        this.id = id;
        this.name = name;
        this.from = from;
    }
}
