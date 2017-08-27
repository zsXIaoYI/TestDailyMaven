package cn.zsza.spring.aspect;

/**
 * Created by ZhangSong on 2017/8/27.
 * 13:54
 */
public interface PersonService {
    void save(String name);
    void update(String name,Integer id);
    String getPersonName(Integer id);
}
