package Bank;
import Person.Person;


public class Account {
    private int id = 0;
    private Person person;
    protected double balance;
    private String accountType;

    public Account(Person person, String accountType) {
        this.id++;
        this.accountType = accountType;
        this.person = person;
    }

    public Person getPerson() {
        return person;
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

    @Override
    public String toString() {
        return person.serialize() + "\n" + person.getAddress().serialize() +
                "\n" + accountType + "\n" + balance;

    }

    public String serialize() {
        String serial = person.serialize() + "\n" + person.getAddress().serialize() + "\n";
        String serial1 = toString();
        return serial + serial1;
    }

    public int getId() {
        return id;
    }

}
