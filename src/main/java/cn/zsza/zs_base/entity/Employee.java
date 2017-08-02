package cn.zsza.zs_base.entity;

import lombok.Data;

/**
 * Created by zs on 2017/8/2.
 * 16:59
 */
@Data
public class Employee {
    private String name;
    private double salary;


    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
