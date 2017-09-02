package cn.zsza.spring.jdbc;

import cn.zsza.spring.entity.Person;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;
import java.sql.Types;
/**
 * Created by ZhangSong on 2017/9/2.
 * 12:43
 */
@Data
@Transactional
public class TestTxa {

    private PersonService_jdbc personService_jdbc;

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);     // JdbcTemplate接收一个数据源
    }

    /**
     *
     * deletePerson()方法被 @Transactional(propagation = Propagation.NEVER) 修饰
     *  则在客户端调用testNever()方法时，则会抛出异常
     *   org.springframework.transaction.IllegalTransactionStateException:
     *   Existing transaction found for transaction marked with propagation 'never'
     * @param id
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void testNever(Integer id) throws Exception {
        personService_jdbc.deletePerson(id);
    }

    /**
     * 注释掉TestTxa上的@Transactional注解
     * 则客户端调用testMANDATORY()时，由于其deletePerson()被@Transactional(propagation = Propagation.MANDATORY)标注
     * testMANDATORY()方法被会抛出异常
     *  org.springframework.transaction.IllegalTransactionStateException:
     *  No existing transaction found for transaction marked with propagation 'mandatory'
     * @param id
     * @throws Exception
     */
    public void testMANDATORY(Integer id) throws Exception {
        System.out.println("id:" + id);
        personService_jdbc.deletePerson(id);

    }

    /**
     * deletePersonNeSTED()被 @Transactional(propagation = Propagation.NESTED) 修饰,
     * 该方法出现unchecked例外，只有deletePersonNeSTED()方法会回滚，不会导致前后事务代码回滚
     * @param id
     * @param person
     */
    public void testNESTED(Integer id, Person person) {

        jdbcTemplate.update("INSERT into spring_jdbc(name) VALUES(?)",new Object[]{person.getName()},
                new int[]{Types.VARCHAR});

        try {
            personService_jdbc.deletePersonNeSTED(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(".........");
        jdbcTemplate.update("INSERT into spring_jdbc(name) VALUES(?)",new Object[]{"last"},
                new int[]{Types.VARCHAR});

    }

}
