package Main;

import Bank.Account;
import BankDAO.AccountDaoImplementation;
import BankDAO.PersonDaoImplementation;
import Person.Person;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestMain {

    private static PersonDaoImplementation personDao;
    private static AccountDaoImplementation accountDao;


    public static void main(String[] args){
        personDao = new PersonDaoImplementation();
        accountDao = new AccountDaoImplementation();
        startBankMenu();

    }

    public static void startBankMenu() {
        Scanner scanner = new Scanner(System.in);
        int selection;

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
                    createAccount(scanner);

                }

                /*case 2 -> {
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
                }*/
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

    public static void createAccount(Scanner scanner) {
        System.out.println("Enter SSN: ");
        int ssn = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter street number: ");
        int streetNum = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter street name: ");
        String streetName = scanner.nextLine();

        System.out.println("Enter city: ");
        String city = scanner.nextLine();

        System.out.println("Enter state: ");
        String state = scanner.nextLine();

        System.out.println("Enter zip code: ");
        int zip = scanner.nextInt();
        scanner.nextLine();

        Person person = new Person(ssn, firstName, lastName, streetNum, streetName, city, state, zip);


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
            case "normal" -> account = new Account(accountType);
            /*case "overdraft" -> {
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
            }*/
        }


        try {
            personDao.add(person);
            assert account != null;
            accountDao.add(account, ssn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
