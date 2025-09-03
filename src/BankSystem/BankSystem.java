package BankSystem;

// Project: Bank System (ZZZ Edition)
//https://github.com/mazamunexd
//https://github.com/Masamune-dxd

// import java.util.HashMap;
// import java.util.Map;
// import java.util.Scanner;
// import java.util.Random;
import java.util.*;

public class BankSystem {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Map<String, Admin> admins = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initializeSystem();
        showMainMenu();
    }

    private static void initializeSystem() {
        // users account
        accounts.put("user1", new Account("user1", "pass1", "Jane Doe", 150_000));
        accounts.put("user2", new Account("user2", "pass2", "Ellen Joe", 100_000));
        accounts.put("user3", new Account("user3", "pass3", "Tsukishiro Yanagi", 200_000));
        accounts.put("user4", new Account("user4", "pass4", "Hoshimi Miyabi", 250_000));
        accounts.put("user5", new Account("user5", "pass5", "Burnice", 90_000));
        accounts.put("user6", new Account("user6", "pass6", "Pulchra Fellini", 88_000));
        accounts.put("user7", new Account("user7", "pass7", "Nicole Demara", 50_000));
        accounts.put("user8", new Account("user8", "pass8", "Zhu Yuan", 100_500));
        accounts.put("user9", new Account("user9", "pass9", "Corin Wickes", 20_000));
        accounts.put("user10", new Account("user10", "pass10", "Yixuan", 300_000));

        // admin account
        admins.put("admin", new Admin("admin", "admin123"));
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println();
            System.out.println("==============================================");
            System.out.println("|                                            |");
            System.out.println("|         Welcome to the Bank System         |");
            System.out.println("|                                            |");
            System.out.println("==============================================");
            System.out.println("|              1. User Login                 |");
            System.out.println("|              2. Admin Login                |");
            System.out.println("|              3. Exit                       |");
            System.out.println("==============================================");
            System.out.println();
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    userLogin();
                    break;
                case 2:
                    adminLogin();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("=================================================");
                    System.out.println("| Thank you for using our bank system. Goodbye! |");
                    System.out.println("=================================================");
                    System.exit(0);
                default:
                    System.out.println();
                    System.out.println("=====================================");
                    System.out.println("| Invalid option. Please try again. |");
                    System.out.println("=====================================");
                    System.out.println();
            }
        }
    }

    private static void userLogin() {
        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (accounts.containsKey(username) && accounts.get(username).getPassword().equals(password)) {
            userMenu(accounts.get(username));
        } else {
            System.out.println();
            System.out.println("=================================");
            System.out.println("| Invalid username or password. |");
            System.out.println("=================================");
            System.out.println();
        }
    }

    private static void userMenu(Account account) {
        while (true) {
            System.out.println();
            System.out.println("================================================");
            System.out.printf ("|          User Menu - %-23s |\n", account.getFullName());
            System.out.println("================================================");
            System.out.println("| 1. Check Balance                             |");
            System.out.println("| 2. Deposit Money                             |");
            System.out.println("| 3. Withdraw Money                            |");
            System.out.println("| 4. Transfer Money                            |");
            System.out.println("| 5. View Account Details                      |");
            System.out.println("| 6. Logout                                    |");
            System.out.println("================================================");
            System.out.println();
            System.out.print("Choose an option: ");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("===========================================");
                    System.out.printf("| %-39s |\n", String.format("Account Number: %s", account.getAccountNumber()));
                    System.out.printf("| %-39s |\n", String.format("Your current balance: $%.2f", account.getBalance()));
                    System.out.println("===========================================");
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println();
                    double oldDepositBalance = account.getBalance();
                    if (depositAmount > 0) {
                        account.deposit(depositAmount);
                        System.out.println();
                        System.out.println("============================================");
                        System.out.printf("| %-40s |\n", "          Deposit successful.");
                        System.out.println("============================================");
                        System.out.printf("| %-40s |\n", String.format("Old Balance: $%.2f", oldDepositBalance));
                        System.out.printf("| %-40s |\n", String.format("Amount Deposited: $%.2f", depositAmount));
                        System.out.printf("| %-40s |\n", String.format("Your New Balance: $%.2f", account.getBalance()));
                        System.out.println("============================================");
                        System.out.println();
                    } else {
                        account.deposit(depositAmount);
                        System.out.println("================================================");
                        System.out.printf("| %-40s |\n", "Deposit failed. Please enter a valid amount.");
                        System.out.println("================================================");
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println();
                    double oldBalance = account.getBalance();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println();
                        System.out.println("============================================");
                        System.out.printf("| %-40s |\n", "          Withdraw successful.");
                        System.out.println("============================================");
                        System.out.printf("| %-40s |\n", String.format("Old Balance: $%.2f", oldBalance));
                        System.out.printf("| %-40s |\n", String.format("Amount Withdrawn: $%.2f", withdrawAmount));
                        System.out.printf("| %-40s |\n", String.format("Your New Balance: $%.2f", account.getBalance()));
                        System.out.println("============================================");
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.println("===========================================");
                        System.out.println("|  Insufficient funds or invalid amount.  |");
                        System.out.println("===========================================");
                        System.out.printf ("| %-39s |\n", String.format("Current Balance: $%.2f", account.getBalance()));
                        System.out.printf ("| %-39s |\n", String.format("Attempted Withdraw: $%.2f", withdrawAmount));
                        System.out.println("===========================================");
                        System.out.println("| Please try again.                       |");
                        System.out.println("===========================================");
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.print("Enter recipient username: ");
                    String recipient = scanner.nextLine();
                    if (accounts.containsKey(recipient)) {
                        System.out.print("Enter amount to transfer: $");
                        double transferAmount = scanner.nextDouble();
                        double receivedAmount = transferAmount;
                        scanner.nextLine();
                        System.out.println();
                        if (account.getBalance() >= transferAmount && transferAmount > 0) {
                            double oldTransferBalance = account.getBalance();
                            account.setBalance(oldTransferBalance - transferAmount);
                            Account recipientAccount = accounts.get(recipient);
                            recipientAccount.setBalance(recipientAccount.getBalance() + transferAmount);
                            System.out.println();
                            System.out.println("============================================");
                            System.out.printf("| %-40s |\n", "          Transfer successful.");
                            System.out.println("============================================");
                            System.out.printf("| %-40s |\n", "Transaction Details:");     
                            System.out.println("============================================");         
                            System.out.printf("| %-40s |\n", String.format(" Sender Details:"));
                            System.out.printf("| %-40s |\n", String.format("   Sender: %s", account.getFullName()));
                            System.out.printf("| %-40s |\n", String.format("   Account Number: %s", account.getAccountNumber()));
                            System.out.printf("| %-40s |\n", String.format("   Amount Transferred : $%.2f", receivedAmount));
                            System.out.println("============================================");
                            System.out.printf("| %-40s |\n", String.format(" Recipient Details:"));
                            System.out.printf("|  %-40s|\n", "  Recipient: " + recipientAccount.getFullName());
                            System.out.printf("|  %-40s|\n", "  Account Number: " + recipientAccount.getAccountNumber());
                            System.out.printf("| %-40s |\n", String.format("   Amount Received : $%.2f", transferAmount));
                            System.out.println("============================================");
                            System.out.printf("| %-40s |\n", String.format("Old balance: $%.2f", oldTransferBalance));
                            System.out.printf("| %-40s |\n", String.format("Your New balance: $%.2f", account.getBalance()));
                            System.out.println("============================================");
                            System.out.println();
                        } else {
                            System.out.println();
                            System.out.println("==========================================================");
                            System.out.println("| Transfer failed. Insufficient funds or invalid amount. |");
                            System.out.println("==========================================================");
                            System.out.println();
                            

                        }
                    } else {
                        System.out.println();
                        System.out.println("================================");
                        System.out.println("| Recipient account not found. |");
                        System.out.println("================================");
                        System.out.println();
                    }
                    break;
                case 5:
                    account.displayAccountDetails();
                    break;
                case 6:
                    System.out.println();
                    System.out.println("=================================================");    
                    System.out.println("| You have successfully logged out. Goodbye!    |");
                    System.out.println("=================================================");
                    System.out.println();
                    return;
                default:
                    System.out.println();
                    System.out.println("=====================================");
                    System.out.println("| Invalid option. Please try again. |");
                    System.out.println("=====================================");
                    System.out.println();
            }
        }
    }

    private static void adminLogin() {
        System.out.print("\nEnter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (admins.containsKey(username) && admins.get(username).getPassword().equals(password)) {
            adminMenu(admins.get(username));
        } else {
            System.out.println();
            System.out.println("================================================");
            System.out.println("| Invalid admin credentials. Please try again. |");
            System.out.println("================================================");
            System.out.println();
        }
    }

    private static void adminMenu(Admin admin) {
        while (true) {
            System.out.println();
            System.out.println("==================================");
            System.out.println("|           Admin Menu           |");
            System.out.println("==================================");
            System.out.println("| 1. View All Accounts           |");
            System.out.println("| 2. View Specific Account       |");
            System.out.println("| 3. Add Funds to Account        |");
            System.out.println("| 4. Deduct Funds from Account   |");
            System.out.println("| 5. Create New Account          |");
            System.out.println("| 6. Generate System Report      |");
            System.out.println("| 7. Logout                      |");
            System.out.println("==================================");
            System.out.println();
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    admin.viewAllAccounts(accounts);
                    break;
                case 2:
                    System.out.print("Enter account username: ");
                    String username = scanner.nextLine();
                    if (accounts.containsKey(username)) {
                        accounts.get(username).displayAccountDetails();
                    } else {
                        System.out.println();
                        System.out.println("======================");
                        System.out.println("| Account not found. |");
                        System.out.println("======================");
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.print("Enter account username: ");
                    String depositAccount = scanner.nextLine();
                    if (accounts.containsKey(depositAccount)) {
                        System.out.print("Enter amount to add: $");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        Account acc = accounts.get(depositAccount);
                        double oldBalance = acc.getBalance();
                        acc.setBalance(oldBalance + amount);
                        System.out.println();
                        System.out.println("================================================");
                        System.out.printf("| %-44s |\n", "          Funds added successfully. ");
                        System.out.println("================================================");
                        System.out.printf("| %-20s $%-17.2f      |\n", "Old balance:", oldBalance);
                        System.out.printf("| %-20s $%-17.2f      |\n", "Amount added:", amount);
                        System.out.printf("| %-20s $%-17.2f      |\n", "New balance:", acc.getBalance());
                        String holder = acc.getFullName();
                        if (holder.length() > 25) holder = holder.substring(0, 25);
                        System.out.printf("| %-20s %-23s |\n", "Account Number:", acc.getAccountNumber());
                        System.out.printf("| %-20s %-23s |\n", "Account Holder:", holder);
                        System.out.println("================================================");
                        System.out.println();                
                    } else {
                        System.out.println();
                        System.out.println("======================");
                        System.out.println("| Account not found. |");
                        System.out.println("======================");
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.print("Enter account username: ");
                    String withdrawAccount = scanner.nextLine();
                    if (accounts.containsKey(withdrawAccount)) {
                        System.out.print("Enter amount to deduct: $");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        if (accounts.get(withdrawAccount).getBalance() >= amount && amount > 0) {
                            accounts.get(withdrawAccount).setBalance(accounts.get(withdrawAccount).getBalance() - amount);
                            Account acc = accounts.get(withdrawAccount);
                            double oldBalance = acc.getBalance();
                            acc.setBalance(oldBalance - amount);
                            System.out.println();
                            System.out.println("================================================");
                            System.out.printf("| %-44s |\n", "        Funds deducted successfully.");
                            System.out.println("================================================");
                            System.out.printf("| %-20s $%-17.2f      |\n", "Old balance:", oldBalance);
                            System.out.printf("| %-20s $%-17.2f      |\n", "Amount deducted:", amount);
                            System.out.printf("| %-20s $%-17.2f      |\n", "New balance:", acc.getBalance());
                            String holder = acc.getFullName();
                            String accountNumber = acc.getAccountNumber();
                            if (holder.length() > 25) holder = holder.substring(0, 25);
                                System.out.printf("| %-20s %-23s |\n", "Account Number:", accountNumber);
                                System.out.printf("| %-20s %-23s |\n", "Account Holder:", holder);
                                System.out.println("================================================");
                                System.out.println();
                        } else {
                            System.out.println();
                            System.out.println("=========================================");
                            System.out.println("| Insufficient funds or invalid amount. |");
                            System.out.println("=========================================");
                            System.out.println();

                        }
                    } else {
                        System.out.println();
                        System.out.println("======================");
                        System.out.println("| Account not found. |");
                        System.out.println("======================");
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Enter full name: ");
                    String fullName = scanner.nextLine();
                    double initialBalance = 10000 + random.nextInt(90000);
                    accounts.put(newUsername, new Account(newUsername, newPassword, fullName, initialBalance));
                    System.out.println();
                    System.out.println("================================================");
                    System.out.printf("| %-44s |\n", "     New account created successfully.");
                    System.out.println("================================================");
                    System.out.printf("| %-20s %-23s |\n", "Account Number:", accounts.get(newUsername).getAccountNumber());
                    System.out.printf("| %-20s %-23s |\n", "Account Holder:", fullName);
                    System.out.printf("| %-20s %-23s |\n", "Username:", newUsername);
                    System.out.printf("| %-20s $%-17.2f      |\n", "Initial Balance:", initialBalance);
                    System.out.println("================================================");
                    System.out.println();
                    break;
                case 6:
                    admin.generateSystemReport(accounts);
                    break;
                case 7:
                    System.out.println();
                    System.out.println("==================================================");
                    System.out.println("| Thank you for using the admin system. Goodbye! |");
                    System.out.println("==================================================");
                    System.out.println();
                    return;
                default:
                    System.out.println();
                    System.out.println("=====================================");
                    System.out.println("| Invalid option. Please try again. |");
                    System.out.println("=====================================");
                    System.out.println();
            }
        }
    }
}

// users account details
class Account {
    private String username;
    private String password;
    private String fullName;
    private double balance;
    private String accountNumber;

    public Account(String username, String password, String fullName, double balance) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.balance = balance;
        this.accountNumber = generateAccountNumber();
    }

    private String generateAccountNumber() {
        Random rand = new Random();
        return "ZZZ" + (100000 + rand.nextInt(900000));
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } 
        else {
            System.out.println();
            System.out.println("================================================");
            System.out.println("|            Invalid deposit amount.           |");

        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void displayAccountDetails() {
        System.out.println();
        System.out.println("=======================================");
        System.out.println("|           Account Details           |");
        System.out.println("=======================================");
        System.out.printf ("| Account Number:  %-17s  |\n", accountNumber);
        System.out.printf ("| Username:        %-17s  |\n", username);
        System.out.printf ("| Full Name:       %-17s  |\n", fullName);
        System.out.printf ("| Balance:         $%-12.2f      |\n", balance);
        System.out.println("=======================================");
        System.out.println();
    }
}

// admin access
class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void viewAllAccounts(Map<String, Account> accounts) {
        System.out.println();
        System.out.println("===================================================================================");
        System.out.println("| All Accounts in the System:                                                     |");
        System.out.println("===================================================================================");
        System.out.printf("%-15s %-20s %-20s %-15s %-15s\n",
            "| Username", "Full Name", "Account Number", "Balance", " Status |");

        for (Account account : accounts.values()) {
            String status = account.getBalance() >= 10000 ? "Active" : "Inactive";
            System.out.printf("%-15s %-20s %-20s $%-15.2f %-15s\n", "| " +
                account.getUsername(),
                account.getFullName().substring(0, Math.min(15, account.getFullName().length())),
                account.getAccountNumber(),
                account.getBalance(),
                status + " |");
            }
            System.out.println("===================================================================================");
            System.out.println();
    }

    public void generateSystemReport(Map<String, Account> accounts) {
        double totalBalance = 0;
        int accountCount = accounts.size();
        int activeAccounts = 0;
        double highestBalance = 0;
        String richestAccount = "";

        for (Account account : accounts.values()) {
            totalBalance += account.getBalance();
            if (account.getBalance() >= 10000) {
                activeAccounts++;
            }
            if (account.getBalance() > highestBalance) {
                highestBalance = account.getBalance();
                richestAccount = account.getUsername() + " (" + account.getAccountNumber() + ")";
            }
        }

        System.out.println();
        System.out.println("============================================");
        System.out.println("|               System Report              |");
        System.out.println("============================================");
        System.out.printf ("| Total Accounts:       %-10d         |\n", accountCount);
        System.out.printf ("| Active Accounts:      %-10d         |\n", activeAccounts);
        System.out.printf ("| Inactive Accounts:    %-10d         |\n", (accountCount - activeAccounts));
        System.out.printf ("| Total System Balance: $%-12.2f      |\n", totalBalance);
        System.out.printf ("| Average Balance:      $%-12.2f      |\n", (totalBalance/accountCount));
        System.out.printf ("| Highest Balance:      $%-12.2f      |\n", highestBalance);
        System.out.printf ("| Richest Account:      %-18s |\n", richestAccount);    
        System.out.println("============================================");
        System.out.println();
    }
}

// mazamunexd 
// Masamune-dxd