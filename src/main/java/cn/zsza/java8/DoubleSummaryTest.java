package cn.zsza.java8;

import cn.zsza.zs_base.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zs on 2017/8/2.
 * 17:01
 */
public class DoubleSummaryTest {
    private List<Employee> list = Arrays.asList(
            new Employee("小1",12.5),
            new Employee("小2",2.5),
            new Employee("小3",3.5)
    );
    @Test
    public void initData(){
        DoubleSummaryStatistics ds = list.stream()
                .collect(Collectors.summarizingDouble((e -> e.getSalary())));
        System.out.println(ds.getSum());
        System.out.println(ds.getAverage());
    }
}
