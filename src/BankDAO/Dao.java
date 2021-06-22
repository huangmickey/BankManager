package BankDAO;
import Bank.*;
import Person.Person;
import Person.Address;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dao {

    private List<Account> accounts;

    public Dao() {
        accounts = new ArrayList<>();
    }

    public Dao(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void save(Account ac) {
        accounts.add(ac);
        update();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getAccountById(int id) {
        return accounts.get(id - 1);
    }

    public void update() {
        try {
            PrintStream printStream = new PrintStream("file.txt");
            for(Account account : accounts) {
                printStream.println(account);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public void load() {

        List<Account> loadedAccounts = new ArrayList<>();
        List<String> linesOfFile = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("file.txt"));
            while (scanner.hasNextLine()) {
                linesOfFile.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }

        String firstName;
        String lastName;
        String street;
        String city;
        String accountType;
        double balance;
        String overdraft;
        String limit;
        Person p;
        Account a = null;
        int i = 0;
        while (i <= linesOfFile.size() - 1) {

            firstName = linesOfFile.get(i).substring(0, linesOfFile.get(i).indexOf(" "));
            lastName = linesOfFile.get(i).substring(linesOfFile.get(i).indexOf(" ") + 1);
            i++;
            street = linesOfFile.get(i);
            i++;
            city = linesOfFile.get(i);
            i++;

            p = new Person(firstName, lastName, new Address(street, city));

            accountType = linesOfFile.get(i);
            i++;
            balance = Double.parseDouble(linesOfFile.get(i));
            i++;
            if (accountType.equals("normal")) {

                a = new Account(p, accountType);
                a.deposit(balance);

            } else if (accountType.equals("overdraft")) {
                overdraft = linesOfFile.get(i);
                a = new OverdraftAccount(p, Double.parseDouble(overdraft), accountType);
                a.deposit(balance);
                i++;
            } else {
                limit = linesOfFile.get(i);
                a = new LimitedActionAccount(p, Double.parseDouble(limit), accountType);
                a.deposit(balance);
                i++;
            }
            loadedAccounts.add(a);
        }
        this.accounts = loadedAccounts;
    }
}
