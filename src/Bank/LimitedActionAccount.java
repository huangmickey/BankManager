package Bank;

import Person.Person;

public class LimitedActionAccount extends Account {

    private double limit;
    private String accountType;

    public LimitedActionAccount(Person person, double limit, String accountType) {
        super(person, accountType);
        this.limit = limit;

    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > limit || amount < 0 || amount > balance) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    @Override
    public boolean deposit(double amount) {
        if(amount > limit || amount < 0) {
            return false;
        } else {
            balance += amount;
            return true;
        }
    }
    @Override
    public String toString() {
        return super.toString() + "\n" + limit;

    }
}
