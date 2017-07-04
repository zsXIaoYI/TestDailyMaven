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

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
