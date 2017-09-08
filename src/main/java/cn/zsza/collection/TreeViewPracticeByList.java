package cn.zsza.collection;

import cn.zsza.zs_base.entity.Department;
import org.junit.Test;
import java.util.*;
/**
 * Created by ZhangSong on 2017/9/8.
 * 19:51
 */
public class TreeViewPracticeByList {
    public static List<Department> findTopLevelDepartmentList(){
        Department dept_1_1 = new Department();
        dept_1_1.setId(11L);
        dept_1_1.setName("宣传部");

        Department dept_1_2 = new Department();
        dept_1_2.setId(12L);
        dept_1_2.setName("业务部");

        Department dept_1_2_1 = new Department();
        dept_1_2_1.setId(121L);
        dept_1_2_1.setName("业务一部");

        Department dept_1_2_2 = new Department();
        dept_1_2_2.setId(122L);
        dept_1_2_2.setName("业务二部");

        dept_1_2_1.setParent(dept_1_2);
        dept_1_2_2.setParent(dept_1_2);

        Set<Department> children_0 = new LinkedHashSet<>();
        children_0.add(dept_1_2_1);
        children_0.add(dept_1_2_2);
        dept_1_2.setChildren(children_0);
        /**
         * 一级部门
         */
        Department dept_1 = new Department();
        dept_1.setId(1L);
        dept_1.setName("市场部");

        dept_1_1.setParent(dept_1);
        dept_1_2.setParent(dept_1);

        Set<Department> children_1 = new LinkedHashSet<>();
        children_1.add(dept_1_1);
        children_1.add(dept_1_2);

        dept_1.setChildren(children_1);

        Department dept_2_1 = new Department();
        dept_2_1.setId(21L);
        dept_2_1.setName("开发一部");

        Department dept_2_2 = new Department();
        dept_2_2.setId(22L);
        dept_2_2.setName("开发二部");

        Department dept_2 = new Department();
        dept_2.setId(2L);
        dept_2.setName("开发部");

        dept_2_1.setParent(dept_2);
        dept_2_2.setParent(dept_2);

        Set<Department> children_2 = new LinkedHashSet<>();
        children_2.add(dept_2_1);
        children_2.add(dept_2_2);

        dept_2.setChildren(children_2);

        List<Department> depts = new ArrayList<>();
        depts.add(dept_1);
        depts.add(dept_2);

        return depts;
    }
    /**
     * 练习一
     * 市场部
     * 宣传部
     * 业务部
     * 业务一部
     * 业务二部
     * 开发部
     * 开发一部
     * 开发二部
     */
    @Test
    public void printAllDepts_1(){
        List<Department> topList = findTopLevelDepartmentList();
        // 方式一
//        topList.forEach(e -> showTree(e));

        // 方式二
        showTreeList(topList);
    }

    private void showTree(Department e) {
        // 顶点
        System.out.println(e.getName());
        // 子树
        e.getChildren().forEach(e_child -> showTree(e_child));
    }

    private void showTreeList(Collection<Department> topList) {
        topList.forEach(e -> {
            System.out.println(e.getName());
            showTreeList(e.getChildren());
        });
    }
    @Test
    public void printAllDepts_2(){
        List<Department> topList = findTopLevelDepartmentList();
        showTreeList_2(topList, "┣");
    }

    private void showTreeList_2(Collection<Department> topList, String prefix) {
        topList.forEach(e -> {
            System.out.println(prefix + e.getName());
            showTreeList_2(e.getChildren(), "  " + prefix);
        });
    }

}
