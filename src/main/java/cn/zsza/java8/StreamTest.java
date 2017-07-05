package cn.zsza.java8;

import cn.zsza.zs_base.entity.User;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by zs on 2017/7/4.
 * 18:35
 */

public class StreamTest {
    List<User> userList = new ArrayList<>();
    @Before
    public void init(){
        userList.add(new User(1,"aa","北京"));
        userList.add(new User(2,"bb","南京"));
        userList.add(new User(3,"cc","北京"));
        userList.add(new User(4,"dd","衡水"));
    }
    /**
     * StreamOf构造一个集合
     */
    @Test
    public void testStreamOf(){
        List<String> collected = Stream.of("a","b")
                .collect(Collectors.toList());
        assertThat(collected).isEqualTo(Arrays.asList("a","b"));
    }
    @Test
    public void testFilter(){
        /**
         * 下面代码并未做什么实际工作,filter只刻画了Stream,但没有产生新的集合.像filter这样只描述Stream,最终不产生
         * 新集合的方法叫作惰性求值方法;
         */
        Stream<User> userStream = userList.stream()
                .filter(user -> user.getFrom().equals("北京"));
    }
    /**
     * 查看list中来自北京的用户有多少个
     * 而像count这样最终会从Stream产生值的方法叫作及早求值方法
     * .count()操作属于终止流的操作。
     */
    @Test
    public void testCount1(){
        long count = userList.stream()
                .filter(user -> user.getFrom().equals("北京"))
                .count();
        System.out.println("count:" + count);
    }
    @Test
    public void testCount2(){
        long count = userList.stream()
                .filter(user -> {
                    System.out.println("name:" + user.getName());
                    return user.getFrom().equals("北京");
                })
                .count();
        System.out.println("count:" + count);
    }
    @Test
    public void testMapReturn(){
        List<String> list = userList.stream().map(user -> {
            String from = user.getFrom();
            if ("北京".equals(from))
                return from;
            return "南京";
        }).collect(Collectors.toList());

        System.out.println("list:" + list);
    }

    /**
     * map可以提取User的属性,然后再组装成一个list
     */
    @Test
    public void testMap(){
        List<String> nameList = userList.stream()
                .map(user -> user.getName())
                .collect(Collectors.toList());

        assertThat(nameList).isEqualTo(Arrays.asList("aa","bb","cc","dd"));
    }

}
