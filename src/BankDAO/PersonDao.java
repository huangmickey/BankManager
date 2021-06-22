package BankDAO;

import Person.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {

    int add(Person person) throws SQLException;
    void delete(int ssn) throws SQLException;
    Person getPerson(int ssn) throws SQLException;
    List<Person> getPersons() throws SQLException;
    void update(Person person) throws SQLException;


}
