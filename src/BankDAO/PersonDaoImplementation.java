package BankDAO;

import Person.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImplementation implements PersonDao {

    static Connection connection = DatabaseConnection.getConnection();

    public PersonDaoImplementation() {
        DatabaseTable.checkTable(connection, "PERSON");
    }

    @Override
    public int add(Person person) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO PERSON (SSN, FNAME, LNAME, STREETNUM, STREETNAME, CITY, STATE, ZIP) VALUES(?,?,?,?,?,?,?,?)");
        ps.setInt(1, person.getSsn());
        ps.setString(2, person.getFirstName());
        ps.setString(3, person.getLastName());
        ps.setInt(4, person.getStreetNum());
        ps.setString(5, person.getStreetName());
        ps.setString(6, person.getCity());
        ps.setString(7, person.getState());
        ps.setInt(8, person.getZip());
        return ps.executeUpdate();
    }

    @Override
    public void delete(int ssn) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM PERSON WHERE SSN = ?");
        ps.setInt(1, ssn);
        ps.executeUpdate();
    }

    @Override
    public Person getPerson(int ssn) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM PERSON WHERE SSN = ?");
        ps.setInt(1, ssn);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            String firstName = resultSet.getString("FNAME");
            String lastName = resultSet.getString("LNAME");

            return new Person(ssn, firstName, lastName, 1111, "", "", "", 1111);
        } else {
            return null;
        }
    }
    @Override
    public List<Person> getPersons() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM PERSON");
        ResultSet resultSet = ps.executeQuery();
        List<Person> personList = new ArrayList<>();
        while(resultSet.next()) {
            Person person = new Person();
            person.setSsn(resultSet.getInt("SSN"));
            person.setFirstName(resultSet.getString("FNAME"));
            person.setLastName(resultSet.getString("LNAME"));
            person.setStreetNum(resultSet.getInt("STREETNUM"));
            person.setStreetName(resultSet.getString("STREETNAME"));
            person.setCity(resultSet.getString("CITY"));
            person.setState(resultSet.getString("STATE"));
            person.setZip(resultSet.getInt("ZIP"));


            personList.add(person);
        }
        return personList;
    }
    @Override
    public void update(Person person) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE PERSON SET FNAME=?,LNAME=?,STREETNUM=?,STREETNAME=?,CITY=?,STATE=?,ZIP=? WHERE SSN=?");
        ps.setString(1, person.getFirstName());
        ps.setString(2, person.getLastName());
        ps.setInt(3, person.getStreetNum());
        ps.setString(4, person.getStreetName());
        ps.setString(5, person.getCity());
        ps.setString(6, person.getState());
        ps.setInt(7, person.getZip());
        ps.setInt(8, person.getSsn());

        ps.executeUpdate();
    }
}
