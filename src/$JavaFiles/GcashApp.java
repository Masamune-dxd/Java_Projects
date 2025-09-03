package $JavaFiles;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GcashApp {

    private static Scanner scanner = new Scanner(System.in);
    private static List<User> users = new ArrayList<>();
    private static User currentUser = null;

    public static void main(String[] args) {
        initializeDummyUsers();

        System.out.println("----------------------------------------");
        System.out.println("       Welcome to Simple GCash App!     ");
        System.out.println("----------------------------------------");

        while (true) {
            displayMainMenu();
            int choice = getUserChoice();

            if (currentUser == null) {
                handleGuestMenuChoice(choice);
            } else {
                handleLoggedInMenuChoice(choice);
            }

            if (choice == 0) {
                System.out.println("Thank you for using Simple GCash App! Goodbye!");
                scanner.close();
                break;
            }
        }
    }

    private static void initializeDummyUsers() {
        User user1 = new User("juan.dela@example.com", "password123", "Juan Dela Cruz", "09123456789");
        user1.setBalance(500.00);
        user1.addTransaction(new Transaction("Cash In", 300.00, "Initial cash in", true));
        user1.addTransaction(new Transaction("Transfer Out", 200.00, "To Pedro", true));
        users.add(user1);

        User user2 = new User("pedro.s@example.com", "securepin", "Pedro San Pedro", "09987654321");
        user2.setBalance(250.00);
        user2.addTransaction(new Transaction("Cash In", 150.00, "Initial load", true));
        user2.addTransaction(new Transaction("Transfer In", 200.00, "From Juan", true));
        users.add(user2);

        User user3 = new User("maria.g@example.com", "simplepass", "Maria Gomez", "09001112233");
        user3.setBalance(1000.00);
        users.add(user3);
    }

    private static void displayMainMenu() {
        System.out.println("\n--- Main Menu ---");
        if (currentUser == null) {
            System.out.println("1. Login");
            System.out.println("2. Register New Account");
            System.out.println("0. Exit");
        } else {
            System.out.println("Logged in as: " + currentUser.getFullName());
            System.out.println("1. Check Balance");
            System.out.println("2. Cash In");
            System.out.println("3. Transfer Money");
            System.out.println("4. View All Transactions");
            System.out.println("5. Logout");
            System.out.println("0. Exit Application");
        }
        System.out.print("Enter your choice: ");
    }

    private static void displayTransactionTableHeader() {
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("| %-18s | %-15s | %-12s | %-30s | %-8s |\n",
                "Date", "Type", "Amount", "Description", "Status");
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    private static void displayTransactionRow(Transaction transaction) {
        String status = transaction.isSuccessful() ? "SUCCESS" : "FAILED";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.printf("| %-18s | %-15s | %-12.2f | %-30s | %-8s |\n",
                sdf.format(transaction.getDate()),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getDescription(),
                status);
    }

    private static int getUserChoice() {
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                System.out.print("Enter your choice: ");
            }
        }
    }

    private static void handleGuestMenuChoice(int choice) {
        switch (choice) {
            case 1:
                loginUser();
                break;
            case 2:
                registerUser();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void handleLoggedInMenuChoice(int choice) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                cashIn();
                break;
            case 3:
                transferMoney();
                break;
            case 4:
                viewAllTransactions();
                break;
            case 5:
                logoutUser();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void loginUser() {
        System.out.println("\n--- User Login ---");
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful! Welcome, " + currentUser.getFullName() + "!");
                return;
            }
        }
        System.out.println("Login failed. Invalid email or password.");
    }

    private static void registerUser() {
        System.out.println("\n--- Register New Account ---");
        String email, password, fullName, phoneNumber;

        while (true) {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();
            if (findUserByEmail(email) != null) {
                System.out.println("Email already registered. Please use a different email.");
            } else if (!email.contains("@") || !email.contains(".")) {
                System.out.println("Invalid email format. Must contain '@' and '.'");
            }
            else {
                break;
            }
        }

        System.out.print("Enter Full Name: ");
        fullName = scanner.nextLine();

        while (true) {
            System.out.print("Enter Phone Number (e.g., 09xxxxxxxxx): ");
            phoneNumber = scanner.nextLine();
            if (findUserByPhoneNumber(phoneNumber) != null) {
                System.out.println("Phone number already registered. Please use a different number.");
            } else if (!phoneNumber.matches("^09\\d{9}$")) {
                System.out.println("Invalid phone number format. Must be 11 digits starting with '09'.");
            }
            else {
                break;
            }
        }

        while (true) {
            System.out.print("Enter Password (at least 6 characters): ");
            password = scanner.nextLine();
            if (password.length() < 6) {
                System.out.println("Password must be at least 6 characters long.");
            } else {
                break;
            }
        }

        User newUser = new User(email, password, fullName, phoneNumber);
        users.add(newUser);
        System.out.println("Account registered successfully! You can now login.");
    }

    private static void logoutUser() {
        if (currentUser != null) {
            System.out.println("Logging out " + currentUser.getFullName() + "...");
            currentUser = null;
            System.out.println("Logged out successfully.");
        }
    }

    private static void checkBalance() {
        System.out.println("\n--- Your Balance ---");
        if (currentUser != null) {
            System.out.printf("Current Balance: PHP %.2f\n", currentUser.getBalance());
        } else {
            System.out.println("Please log in to check balance.");
        }
    }

    private static void cashIn() {
        System.out.println("\n--- Cash In ---");
        if (currentUser == null) {
            System.out.println("Please log in to cash in.");
            return;
        }

        System.out.print("Enter amount to cash in: PHP ");
        double amount = -1;
        try {
            amount = scanner.nextDouble();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid amount. Please enter a number.");
            scanner.nextLine();
            return;
        }

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        currentUser.addBalance(amount);
        currentUser.addTransaction(new Transaction("Cash In", amount, "Cash in to account", true));
        System.out.printf("Successfully cashed in PHP %.2f. New balance: PHP %.2f\n", amount, currentUser.getBalance());
    }

    private static void transferMoney() {
        System.out.println("\n--- Transfer Money ---");
        if (currentUser == null) {
            System.out.println("Please log in to transfer money.");
            return;
        }

        System.out.print("Enter recipient's Email or Phone Number: ");
        String recipientIdentifier = scanner.nextLine();

        User recipient = findUserByEmail(recipientIdentifier);
        if (recipient == null) {
            recipient = findUserByPhoneNumber(recipientIdentifier);
        }

        if (recipient == null) {
            System.out.println("Recipient not found.");
            return;
        }

        if (recipient.equals(currentUser)) {
            System.out.println("You cannot transfer money to yourself.");
            return;
        }

        System.out.print("Enter amount to transfer: PHP ");
        double amount = -1;
        try {
            amount = scanner.nextDouble();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid amount. Please enter a number.");
            scanner.nextLine();
            return;
        }

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        if (currentUser.getBalance() < amount) {
            System.out.println("Insufficient balance. Your balance: PHP " + currentUser.getBalance());
            currentUser.addTransaction(new Transaction("Transfer Out", amount, "To " + recipient.getFullName(), false));
            return;
        }

        currentUser.deductBalance(amount);
        recipient.addBalance(amount);

        currentUser.addTransaction(new Transaction("Transfer Out", amount, "To " + recipient.getFullName(), true));
        recipient.addTransaction(new Transaction("Transfer In", amount, "From " + currentUser.getFullName(), true));

        System.out.printf("Successfully transferred PHP %.2f to %s. Your new balance: PHP %.2f\n",
                amount, recipient.getFullName(), currentUser.getBalance());
    }

    private static void viewAllTransactions() {
        System.out.println("\n--- Your Transactions ---");
        if (currentUser == null) {
            System.out.println("Please log in to view transactions.");
            return;
        }

        if (currentUser.getTransactions().isEmpty()) {
            System.out.println("No transactions found yet.");
            return;
        }

        displayTransactionTableHeader();
        for (Transaction t : currentUser.getTransactions()) {
            displayTransactionRow(t);
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    private static User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    private static User findUserByPhoneNumber(String phoneNumber) {
        for (User user : users) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return user;
            }
        }
        return null;
    }

    static class User {
        private String email;
        private String password;
        private String fullName;
        private String phoneNumber;
        private double balance;
        private List<Transaction> transactions;

        public User(String email, String password, String fullName, String phoneNumber) {
            this.email = email;
            this.password = password;
            this.fullName = fullName;
            this.phoneNumber = phoneNumber;
            this.balance = 0.0;
            this.transactions = new ArrayList<>();
        }

        public String getEmail() { return email; }
        public String getPassword() { return password; }
        public String getFullName() { return fullName; }
        public String getPhoneNumber() { return phoneNumber; }
        public double getBalance() { return balance; }
        public List<Transaction> getTransactions() { return transactions; }

        public void setBalance(double balance) { this.balance = balance; }
        public void addBalance(double amount) { this.balance += amount; }
        public void deductBalance(double amount) { this.balance -= amount; }
        public void addTransaction(Transaction transaction) {
            this.transactions.add(transaction);
        }
    }

    static class Transaction {
        private Date date;
        private String type;
        private double amount;
        private String description;
        private boolean successful;

        public Transaction(String type, double amount, String description, boolean successful) {
            this.date = new Date();
            this.type = type;
            this.amount = amount;
            this.description = description;
            this.successful = successful;
        }

        public Date getDate() { return date; }
        public String getType() { return type; }
        public double getAmount() { return amount; }
        public String getDescription() { return description; }
        public boolean isSuccessful() { return successful; }
    }
}
