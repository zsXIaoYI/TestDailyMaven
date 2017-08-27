package cn.zsza.spring.aspect;

/**
 * Created by ZhangSong on 2017/8/27.
 * 13:55
 */
public class PersonServiceBean implements PersonService {

    private String user = null;  // 用代理技术做权限

    public PersonServiceBean() {
    }

    public PersonServiceBean(String user) {
        this.user = user;
    }

    public void save(String name) {
        System.out.println("我是save方法");
//        throw new RuntimeException("save方法异常通知");
    }

    public void update(String name, Integer id) {
        System.out.println("我是更新方法");
    }

    public String getPersonName(Integer id) {
        System.out.println("我是getPersonName方法");
        return "xxcc";
    }
}
