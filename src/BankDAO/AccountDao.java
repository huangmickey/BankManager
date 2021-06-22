package BankDAO;

import Bank.Account;
import Person.Person;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {

    int add(Account account, int ssn) throws SQLException;
    void delete(int accountId) throws SQLException;
    Account getAccount(int accountId) throws SQLException;
    List<Account> getAccounts() throws SQLException;
    void update(Account account) throws SQLException;

}
