package Bank;

import Person.Person;

public class OverdraftAccount extends Account {

    private double overdraft;
    private String accountType;

    public OverdraftAccount(Person person, double overdraft, String accountType) {
        super(person, accountType);
        this.overdraft = overdraft;

    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public boolean withdraw(double amount) {

        if(amount <= getBalance() + overdraft && amount > 0) {
            balance -= amount;
            return true;
        }
        return false;


    }
    @Override
    public String toString() {
        return super.toString() + "\n" + overdraft;
    }


}
