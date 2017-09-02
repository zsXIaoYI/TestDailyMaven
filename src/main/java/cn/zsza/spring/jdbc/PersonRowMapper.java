package cn.zsza.spring.jdbc;

import cn.zsza.spring.entity.Person;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person(resultSet.getString("name"));
        person.setId(resultSet.getInt("id"));
        return person;
    }
}

