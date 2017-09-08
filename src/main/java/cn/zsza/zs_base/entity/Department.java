package cn.zsza.zs_base.entity;

import java.util.HashSet;
import java.util.Set;
/**
 * Created by ZhangSong on 2017/9/8.
 * 19:54
 */
public class Department {
    private Long id;
    private Department parent;
    private Set<Department> children = new HashSet<>();

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public Set<Department> getChildren() {
        return children;
    }

    public void setChildren(Set<Department> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

