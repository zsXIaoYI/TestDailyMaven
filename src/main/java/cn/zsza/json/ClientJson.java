package cn.zsza.json;

import cn.zsza.util.JsonMapper;
import cn.zsza.zs_base.entity.JMapper;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;
import java.util.List;
/**
 * Created by ZhangSong on 2017/9/9.
 * 19:41
 */
public class ClientJson {
    private String jm = "{\"id\":\"1\",\"name\":\"小哥\"}";

    // JSON字符串转换成对象
    @Test
    public void test1(){
        JMapper jMapper = JsonMapper.nonDefaultMapper().fromJson(jm, JMapper.class);
        System.out.println(jMapper.getId() + ".." + jMapper.getName());
        System.out.println(jMapper.toString());
    }
    // JSON列表转换成List<JMapper>
    @Test
    public void test2(){
        String jm = "[{\"id\":\"1\",\"name\":\"小哥\"},{\"id\":\"2\",\"name\":\"小黑\"}]";
        TypeReference<List<JMapper>> reference = new TypeReference<List<JMapper>>(){};

        List<JMapper> list = JsonMapper.nonDefaultMapper().fromJson(jm, reference);
        System.out.println(list);
    }
    @Test
    public void testObjectToString(){
        // 序列化
        String jmStr = JSON.toJSONString(jm);
        System.out.println("序列化后:" + jmStr);
    }
}
