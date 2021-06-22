package BankDAO;

import Bank.Account;
import Person.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImplementation implements AccountDao{

    static Connection connection = DatabaseConnection.getConnection();

    public AccountDaoImplementation() {
        DatabaseTable.checkTable(connection, "ACCOUNT");
    }

    @Override
    public int add(Account account, int ssn) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO ACCOUNT (ACCOUNT_ID, ACCOUNT_TYPE, BALANCE, SSN) VALUES(?, ?, ?, ?)");
        ps.setInt(1, account.getAccountId());
        ps.setString(2, account.getAccountType());
        ps.setDouble(3, account.getBalance());
        ps.setInt(4, ssn);
        return ps.executeUpdate();
    }

    @Override
    public void delete(int accountId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM ACCOUNT WHERE ACCOUNT_ID = ?");
        ps.setInt(1, accountId);
        ps.executeUpdate();
    }

    @Override
    public Account getAccount(int accountId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM ACCOUNT WHERE ACCOUNT_ID = ?");
        ps.setInt(1, accountId);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            String accountType = resultSet.getString("ACCOUNT_TYPE");
            double balance = resultSet.getDouble("BALANCE");
            int ssn = resultSet.getInt("SSN");
            return new Account(accountId, accountType, balance);

        } else {
            return null;
        }
    }

    @Override
    public List<Account> getAccounts() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM ACCOUNT");
        ResultSet resultSet = ps.executeQuery();
        List<Account> accountList = new ArrayList<>();
        while(resultSet.next()) {
            int accountId = resultSet.getInt("ACCOUNT_ID");
            String accountType = resultSet.getString("ACCOUNT_TYPE");
            double balance = resultSet.getDouble("BALANCE");
            int ssn = resultSet.getInt("SSN");
            accountList.add(new Account(accountId, accountType, balance));
        }
        return accountList;
    }

    @Override
    public void update(Account account) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE ACCOUNT SET ACCOUNT_TYPE=?, BALANCE=? WHERE ACCOUNT_ID=?");
        ps.setString(1, account.getAccountType());
        ps.setDouble(2, account.getBalance());
        ps.executeUpdate();
    }
}
