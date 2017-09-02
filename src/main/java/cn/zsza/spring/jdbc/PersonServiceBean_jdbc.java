package cn.zsza.spring.jdbc;

import cn.zsza.spring.entity.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;
/**
 * Created by user on 2015/9/16.
 */
@Transactional   // 打开事务
public class PersonServiceBean_jdbc implements PersonService_jdbc {
//    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);     // JdbcTemplate接收一个数据源
    }
    @Transactional(propagation = Propagation.REQUIRED)  // 默认事务行为
    public void save(Person person) {
        jdbcTemplate.update("INSERT into spring_jdbc(name) VALUES(?)",new Object[]{person.getName()},
                new int[]{Types.VARCHAR});
    }
    public void update(Person person) {
        jdbcTemplate.update("UPDATE spring_jdbc SET name=? WHERE id=?",new Object[]{person.getName(),person.getId()},
                new int[]{Types.VARCHAR, Types.INTEGER});
    }
    @Transactional(propagation = Propagation.NOT_SUPPORTED) // 不开启事务
    public Person getPerson(Integer personId) {
        return (Person) jdbcTemplate.queryForObject("SELECT * FROM spring_jdbc WHERE id=?",new Object[]{personId},new int[]{Types.INTEGER}
        ,new PersonRowMapper());
    }
    public List<Person> getPersons() {
        return (List<Person>) jdbcTemplate.query("SELECT * FROM spring_jdbc",
                new PersonRowMapper());
    }
    @Transactional(rollbackFor = Exception.class )   // 针对checked例外回滚
    public void deletePerson(Integer id) throws Exception {
        jdbcTemplate.update("DELETE FROM spring_jdbc WHERE id=?",new Object[]{id},
                new int[]{Types.INTEGER});
//        throw new RuntimeException("unchecked的例外(运行期)");  //默认 事务回滚   noRollbackFor = RuntimeException.class（不回滚配置）
        throw new Exception("checked的例外");   // 不会回滚
    }
}
