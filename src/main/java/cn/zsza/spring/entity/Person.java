package cn.zsza.spring.entity;

import lombok.Data;

/**
 * Created by user on 2015/9/16.
 */
@Data
public class Person {
    private Integer id;
    private String name;

    public Person(String name) {
        this.name = name;
//        this.id = id;
    }

}
