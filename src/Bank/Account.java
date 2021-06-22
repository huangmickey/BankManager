package Bank;
import Person.Person;


public class Account {
    private int accountId = 0;
    protected double balance;
    private String accountType;

    public Account() {

    }

    public Account(String accountType) {
        this.accountType = accountType;
    }

    public Account(int accountId, String accountType, double balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;

    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }



    public boolean withdraw(double amount) {
        if(amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                return true;
            }
        }
        return false;
    }

    public boolean deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

}
