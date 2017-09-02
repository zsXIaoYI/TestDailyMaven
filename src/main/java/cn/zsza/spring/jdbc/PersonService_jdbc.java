package cn.zsza.spring.jdbc;


import cn.zsza.spring.entity.Person;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by user on 2015/9/16.
 */
public interface PersonService_jdbc {
    void save(Person person);
    void update(Person person);
    Object getPerson(Integer personId);
    List<Person> getPersons();
    void deletePerson(Integer id) throws Exception;
    void deletePersonNeSTED(Integer id) throws FileNotFoundException;

}
