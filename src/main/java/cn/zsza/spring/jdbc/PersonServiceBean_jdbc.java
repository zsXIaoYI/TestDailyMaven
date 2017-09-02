package cn.zsza.spring.jdbc;

import cn.zsza.spring.entity.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Types;
import java.util.List;
/**
 * Created by user on 2015/9/16.
 */
@Transactional   // 打开事务
public class PersonServiceBean_jdbc implements PersonService_jdbc {
    /**
     * @Transactional(propagation = Propagation.NOT_SUPPORTED) 不开启事务
     *
     * REQUIRED(0)
     *   业务方法需要在一个事务中运行。如果方法运行时，已经处在一个事务中，那么加入到该事务，否则为自己创建一个新的事务
     * SUPPORTS(1)
     *   如果业务方法在某个事务内被调用，则方法称为事务的一部分。如果在事务范围外被调用，则方法在没有事务的环境下执行
     * MANDATORY(2),
     *   指定业务方法只能在一个存在的事务中执行，业务方法不能自己发起事务，如果业务方法在没有事务的环境下调用，容器会抛出例外
     * REQUIRES_NEW(3),
     * NO_SUPPORTED(4)
     *   声明方法不需要事务，如果方法没有关联到一个事务，容器不为它开启事务。如果方法在另一个事务中被调用，则该事务会被挂起，
     *   在方法调用结束后，原先的事务便会恢复执行
     * NEVER(5),
     *    不使用事务，如果在某个事务中执行，容器会抛出例外
     * NESTED(6);
     */
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

    /**
     * @Transactional(rollbackFor = Exception.class) : 针对checked例外进行回滚
     * @Transactional(noRollbackFor = RuntimeException.class) : 针对checked例外进行回滚
     * 事务的默认回滚：unchecked的例外，即运行时异常
     *               checked例外则会回滚
     * @param id
     * @throws Exception
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public void deletePerson(Integer id) throws Exception {
        jdbcTemplate.update("DELETE FROM spring_jdbc WHERE id=?",new Object[]{id},
                new int[]{Types.INTEGER});
//        throw new RuntimeException("unchecked的例外(运行期)");
//        throw new Exception("checked的例外");
    }

    @Transactional(propagation = Propagation.NESTED)
    public void deletePersonNeSTED(Integer id) throws FileNotFoundException {
        jdbcTemplate.update("DELETE FROM spring_jdbc WHERE id=?",new Object[]{id},
                new int[]{Types.INTEGER});

        new FileInputStream(new File("test.txt"));
//        int a =  1 / 0;
//        System.out.println(a);
    }

}
