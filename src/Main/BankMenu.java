/*package Main;
import Bank.Account;
import Bank.LimitedActionAccount;
import Bank.OverdraftAccount;
import BankDAO.Dao;
import BankLogic.Logic;
import Person.Person;

import java.util.*;

public class BankMenu {

    public static void main(String[] args) {

        Dao dao = new Dao();
        dao.load();
        startBankMenu(dao);

    }

    public static void startBankMenu(Dao dao) {
        Scanner scanner = new Scanner(System.in);
        int selection = 0;

        do {
            menuDescription();
            while (!scanner.hasNextInt()) {
                System.out.println("Enter a valid number: ");
                scanner.nextInt();
                scanner.nextLine();
            }
            selection = scanner.nextInt();
            scanner.nextLine();
            switch (selection) {
                case 1 -> {
                    Account acc = createAccount(scanner);
                    dao.save(acc);
                }
                case 2 -> {
                    int id = selectAccount(dao, scanner);
                    System.out.println(dao.getAccountById(id));

                }
                case 3 -> {
                    int id = selectAccount(dao, scanner);
                    System.out.println("Deposit Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    if(Logic.deposit(amount, id, dao)) {
                        System.out.println("Deposit Successful");
                        System.out.println("New Balance is: " + dao.getAccountById(id).getBalance());
                    } else {
                        System.out.println("Deposit Failed");
                    }
                    dao.update();
                }
                case 4 -> {
                    int id = selectAccount(dao, scanner);
                    System.out.println("Withdraw Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    if(Logic.withdraw(amount, id, dao)) {
                        System.out.println("Withdraw Successful");
                        System.out.println("New Balance is: " + dao.getAccountById(id).getBalance());
                    } else {
                        System.out.println("Withdraw Failed");
                    }
                    dao.update();
                }
            }
        } while (selection != 5);

    }

    public static void menuDescription() {
        System.out.println();
        System.out.println("1. Create Account");
        System.out.println("2. Show Account");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Exit");
        System.out.println("Enter a number between 1 - 5: ");

    }

    public static int selectAccount(Dao dao, Scanner scanner) {

        List<Account> accounts = dao.getAccounts();
        int selection = 0;
        do {
            for(Account acc : accounts) {
                System.out.println(acc.getId() + ". " + acc.getPerson().getFirstName() + " " + acc.getPerson().getLastName());
            }
            while (!scanner.hasNextInt()) {
                System.out.println("Enter valid number");
                scanner.next();
                scanner.nextLine();
            }
            selection = scanner.nextInt();
            scanner.nextLine();
        } while (selection < 1 || selection > accounts.size());

        return selection;
    }

    public static Account createAccount(Scanner scanner) {

        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter street: ");
        String street = scanner.nextLine();

        System.out.println("Enter city: ");
        String city = scanner.nextLine();

        Person person = new Person(firstName, lastName, new Address(street, city));


        System.out.println("Enter account type (Normal, Overdraft, Limited)");
        String accountType = scanner.nextLine();


        Set<String> accountTypes = new HashSet<>();
        accountTypes.add("normal");
        accountTypes.add("overdraft");
        accountTypes.add("limited");


        accountType = accountType.toLowerCase();
        while (!accountTypes.contains(accountType)) {
            System.out.println("Enter a correct account type");
            accountType = scanner.nextLine();
        }

        Account account = null;

        switch (accountType) {
            case "normal" -> account = new Account(person, accountType);
            case "overdraft" -> {
                System.out.println("Overdraft amount: ");
                double overdraft = scanner.nextDouble();
                scanner.nextLine();
                account = new OverdraftAccount(person, overdraft, accountType);
            }
            case "limited" -> {
                System.out.println("Limit amount: ");
                double limit = scanner.nextDouble();
                scanner.nextLine();
                account = new LimitedActionAccount(person, limit, accountType);
            }
        }
        return account;
    }


}*/
