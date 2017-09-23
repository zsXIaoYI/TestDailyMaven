package cn.zsza.zs_base.entity;

import lombok.Data;

/**
 * Created by ZhangSong on 2017/9/23.
 * 13:27
 */
@Data
public class UU {

    private int age;
    private String name;

    public UU(int age,String name) {
        this.name = name;
        this.age = age;
    }
}
