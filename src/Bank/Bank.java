package Bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts = new ArrayList<>();

    public Bank() {

    }

    public List<Account> getAccountList() {
        return accounts;
    }

    public void setAccountList(List<Account> account) {
        this.accounts = account;
    }

    public int getAccountCount() {
        return accounts.size();
    }

    public Account getAccount(int index) {
        return accounts.get(index);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(int index) {
        accounts.remove(index);
    }

}
