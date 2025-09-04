package BankSystemFrame;

// Project: Bank System (ZZZ Edition)
//https://github.com/mazamunexd
//https://github.com/Masamune-dxd

// import java.util.HashMap;
// import java.util.Map;
// import java.util.Scanner;
// import java.util.Random;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankSystem {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Map<String, Admin> admins = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static Account currentUser = null;
    private static Admin currentAdmin = null;

    public static void main(String[] args) {
        initializeSystem();
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
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

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Bank System - ZZZ Edition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // Main panel with card layout for different screens
        JPanel mainPanel = new JPanel(new CardLayout());
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();

        // Login panel
        JPanel loginPanel = createLoginPanel(cardLayout, mainPanel);
        mainPanel.add(loginPanel, "LOGIN");

        // User menu panel
        JPanel userPanel = createUserPanel(cardLayout, mainPanel);
        mainPanel.add(userPanel, "USER");

        // Admin menu panel
        JPanel adminPanel = createAdminPanel(cardLayout, mainPanel);
        mainPanel.add(adminPanel, "ADMIN");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private static JPanel createLoginPanel(CardLayout cardLayout, JPanel mainPanel) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        Font titleFont = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        JLabel titleLabel = new JLabel("Welcome to Bank System");
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(labelFont);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        panel.add(userLabel, gbc);

        JTextField usernameField = new JTextField(20);
        usernameField.setFont(labelFont);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(usernameField, gbc);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(labelFont);
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(passLabel, gbc);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(labelFont);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(passwordField, gbc);

        JButton userLoginBtn = new JButton("User Login");
        userLoginBtn.setFont(buttonFont);
        userLoginBtn.setBackground(new Color(34, 139, 34));
        userLoginBtn.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(userLoginBtn, gbc);

        JButton adminLoginBtn = new JButton("Admin Login");
        adminLoginBtn.setFont(buttonFont);
        adminLoginBtn.setBackground(new Color(255, 140, 0));
        adminLoginBtn.setForeground(Color.WHITE);
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(adminLoginBtn, gbc);

        JLabel statusLabel = new JLabel("");
        statusLabel.setFont(labelFont);
        statusLabel.setForeground(Color.RED);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panel.add(statusLabel, gbc);

        userLoginBtn.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (accounts.containsKey(username) && accounts.get(username).getPassword().equals(password)) {
                currentUser = accounts.get(username);
                cardLayout.show(mainPanel, "USER");
                statusLabel.setText("");
            } else {
                statusLabel.setText("Invalid username or password");
            }
        });

        adminLoginBtn.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (admins.containsKey(username) && admins.get(username).getPassword().equals(password)) {
                currentAdmin = admins.get(username);
                cardLayout.show(mainPanel, "ADMIN");
                statusLabel.setText("");
            } else {
                statusLabel.setText("Invalid admin credentials");
            }
        });

        return panel;
    }

    private static JPanel createUserPanel(CardLayout cardLayout, JPanel mainPanel) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        // Header
        JPanel headerPanel = new JPanel(new FlowLayout());
        headerPanel.setBackground(new Color(0, 102, 204));
        JLabel headerLabel = new JLabel("User Dashboard");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        // Menu buttons
        JPanel menuPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        menuPanel.setBackground(new Color(240, 248, 255));

        JButton balanceBtn = new JButton("Check Balance");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton transferBtn = new JButton("Transfer");
        JButton detailsBtn = new JButton("Account Details");
        JButton logoutBtn = new JButton("Logout");

        JButton[] buttons = {balanceBtn, depositBtn, withdrawBtn, transferBtn, detailsBtn, logoutBtn};
        for (JButton btn : buttons) {
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.setBackground(new Color(70, 130, 180));
            btn.setForeground(Color.WHITE);
            menuPanel.add(btn);
        }

        // Content area
        JTextArea contentArea = new JTextArea();
        contentArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        contentArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(contentArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Transaction Details"));

        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(menuPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        // Event handlers
        balanceBtn.addActionListener(e -> {
            if (currentUser != null) {
                contentArea.setText("Account Number: " + currentUser.getAccountNumber() + "\n" +
                                  "Current Balance: $" + String.format("%.2f", currentUser.getBalance()));
            }
        });

        depositBtn.addActionListener(e -> {
            if (currentUser != null) {
                String amountStr = JOptionPane.showInputDialog("Enter deposit amount:");
                if (amountStr != null && !amountStr.trim().isEmpty()) {
                    try {
                        double amount = Double.parseDouble(amountStr);
                        if (amount > 0) {
                            double oldBalance = currentUser.getBalance();
                            currentUser.deposit(amount);
                            contentArea.setText("Deposit successful!\n" +
                                              "Old Balance: $" + String.format("%.2f", oldBalance) + "\n" +
                                              "Amount Deposited: $" + String.format("%.2f", amount) + "\n" +
                                              "New Balance: $" + String.format("%.2f", currentUser.getBalance()));
                        } else {
                            contentArea.setText("Invalid deposit amount.");
                        }
                    } catch (NumberFormatException ex) {
                        contentArea.setText("Invalid amount format.");
                    }
                } else {
                    contentArea.setText("Deposit cancelled.");
                }
            }
        });

        withdrawBtn.addActionListener(e -> {
            if (currentUser != null) {
                String amountStr = JOptionPane.showInputDialog("Enter withdrawal amount:");
                if (amountStr != null && !amountStr.trim().isEmpty()) {
                    try {
                        double amount = Double.parseDouble(amountStr);
                        double oldBalance = currentUser.getBalance();
                        if (currentUser.withdraw(amount)) {
                            contentArea.setText("Withdrawal successful!\n" +
                                              "Old Balance: $" + String.format("%.2f", oldBalance) + "\n" +
                                              "Amount Withdrawn: $" + String.format("%.2f", amount) + "\n" +
                                              "New Balance: $" + String.format("%.2f", currentUser.getBalance()));
                        } else {
                            contentArea.setText("Insufficient funds or invalid amount.");
                        }
                    } catch (NumberFormatException ex) {
                        contentArea.setText("Invalid amount format.");
                    }
                } else {
                    contentArea.setText("Withdrawal cancelled.");
                }
            }
        });

        transferBtn.addActionListener(e -> {
            if (currentUser != null) {
                String recipient = JOptionPane.showInputDialog("Enter recipient username:");
                if (recipient != null && !recipient.trim().isEmpty()) {
                    if (accounts.containsKey(recipient)) {
                        String amountStr = JOptionPane.showInputDialog("Enter transfer amount:");
                        if (amountStr != null && !amountStr.trim().isEmpty()) {
                            try {
                                double amount = Double.parseDouble(amountStr);
                                if (currentUser.getBalance() >= amount && amount > 0) {
                                    Account recipientAccount = accounts.get(recipient);
                                    currentUser.setBalance(currentUser.getBalance() - amount);
                                    recipientAccount.setBalance(recipientAccount.getBalance() + amount);
                                    contentArea.setText("Transfer successful!\n" +
                                                      "Recipient: " + (recipientAccount.getFullName() != null ? recipientAccount.getFullName() : "N/A") + "\n" +
                                                      "Amount Transferred: $" + String.format("%.2f", amount) + "\n" +
                                                      "Your New Balance: $" + String.format("%.2f", currentUser.getBalance()));
                                } else {
                                    contentArea.setText("Insufficient funds or invalid amount.");
                                }
                            } catch (NumberFormatException ex) {
                                contentArea.setText("Invalid amount format.");
                            }
                        } else {
                            contentArea.setText("Transfer cancelled.");
                        }
                    } else {
                        contentArea.setText("Recipient account not found.");
                    }
                } else {
                    contentArea.setText("Transfer cancelled.");
                }
            }
        });

        detailsBtn.addActionListener(e -> {
            if (currentUser != null) {
                contentArea.setText("Account Details:\n" +
                                  "Account Number: " + currentUser.getAccountNumber() + "\n" +
                                  "Username: " + currentUser.getUsername() + "\n" +
                                  "Full Name: " + currentUser.getFullName() + "\n" +
                                  "Balance: $" + String.format("%.2f", currentUser.getBalance()));
            }
        });

        logoutBtn.addActionListener(e -> {
            currentUser = null;
            cardLayout.show(mainPanel, "LOGIN");
            contentArea.setText("");
        });

        return panel;
    }

    private static JPanel createAdminPanel(CardLayout cardLayout, JPanel mainPanel) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        // Header
        JPanel headerPanel = new JPanel(new FlowLayout());
        headerPanel.setBackground(new Color(255, 140, 0));
        JLabel headerLabel = new JLabel("Admin Dashboard");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        // Menu buttons
        JPanel menuPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        menuPanel.setBackground(new Color(240, 248, 255));

        JButton viewAllBtn = new JButton("View All Accounts");
        JButton viewSpecificBtn = new JButton("View Specific Account");
        JButton addFundsBtn = new JButton("Add Funds");
        JButton deductFundsBtn = new JButton("Deduct Funds");
        JButton createAccountBtn = new JButton("Create Account");
        JButton systemReportBtn = new JButton("System Report");
        JButton logoutBtn = new JButton("Logout");

        JButton[] buttons = {viewAllBtn, viewSpecificBtn, addFundsBtn, deductFundsBtn, createAccountBtn, systemReportBtn, logoutBtn};
        for (JButton btn : buttons) {
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.setBackground(new Color(255, 69, 0));
            btn.setForeground(Color.WHITE);
            menuPanel.add(btn);
        }

        // Content area
        JTextArea contentArea = new JTextArea();
        contentArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        contentArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(contentArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Admin Actions"));

        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(menuPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        // Event handlers
        viewAllBtn.addActionListener(e -> {
            if (currentAdmin != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("All Accounts:\n\n");
                sb.append(String.format("%-15s %-20s %-20s %-15s %-15s\n", "Username", "Full Name", "Account Number", "Balance", "Status"));
                sb.append("--------------------------------------------------------------------------------\n");
                for (Account account : accounts.values()) {
                    String status = account.getBalance() >= 10000 ? "Active" : "Inactive";
                    String fullName = account.getFullName() != null ? account.getFullName() : "N/A";
                    sb.append(String.format("%-15s %-20s %-20s $%-15.2f %-15s\n",
                        account.getUsername(),
                        fullName.substring(0, Math.min(15, fullName.length())),
                        account.getAccountNumber(),
                        account.getBalance(),
                        status));
                }
                contentArea.setText(sb.toString());
            }
        });

        viewSpecificBtn.addActionListener(e -> {
            if (currentAdmin != null) {
                String username = JOptionPane.showInputDialog("Enter account username:");
                if (username != null && !username.trim().isEmpty()) {
                    if (accounts.containsKey(username)) {
                        Account acc = accounts.get(username);
                        contentArea.setText("Account Details:\n" +
                                          "Account Number: " + acc.getAccountNumber() + "\n" +
                                          "Username: " + acc.getUsername() + "\n" +
                                          "Full Name: " + (acc.getFullName() != null ? acc.getFullName() : "N/A") + "\n" +
                                          "Balance: $" + String.format("%.2f", acc.getBalance()));
                    } else {
                        contentArea.setText("Account not found.");
                    }
                } else {
                    contentArea.setText("Operation cancelled.");
                }
            }
        });

        addFundsBtn.addActionListener(e -> {
            if (currentAdmin != null) {
                String username = JOptionPane.showInputDialog("Enter account username:");
                if (username != null && !username.trim().isEmpty()) {
                    if (accounts.containsKey(username)) {
                        String amountStr = JOptionPane.showInputDialog("Enter amount to add:");
                        if (amountStr != null && !amountStr.trim().isEmpty()) {
                            try {
                                double amount = Double.parseDouble(amountStr);
                                Account acc = accounts.get(username);
                                double oldBalance = acc.getBalance();
                                acc.setBalance(oldBalance + amount);
                                contentArea.setText("Funds added successfully!\n" +
                                                  "Account: " + (acc.getFullName() != null ? acc.getFullName() : "N/A") + "\n" +
                                                  "Old Balance: $" + String.format("%.2f", oldBalance) + "\n" +
                                                  "Amount Added: $" + String.format("%.2f", amount) + "\n" +
                                                  "New Balance: $" + String.format("%.2f", acc.getBalance()));
                            } catch (NumberFormatException ex) {
                                contentArea.setText("Invalid amount format.");
                            }
                        } else {
                            contentArea.setText("Operation cancelled.");
                        }
                    } else {
                        contentArea.setText("Account not found.");
                    }
                } else {
                    contentArea.setText("Operation cancelled.");
                }
            }
        });

        deductFundsBtn.addActionListener(e -> {
            if (currentAdmin != null) {
                String username = JOptionPane.showInputDialog("Enter account username:");
                if (username != null && !username.trim().isEmpty()) {
                    if (accounts.containsKey(username)) {
                        String amountStr = JOptionPane.showInputDialog("Enter amount to deduct:");
                        if (amountStr != null && !amountStr.trim().isEmpty()) {
                            try {
                                double amount = Double.parseDouble(amountStr);
                                Account acc = accounts.get(username);
                                if (acc.getBalance() >= amount && amount > 0) {
                                    double oldBalance = acc.getBalance();
                                    acc.setBalance(oldBalance - amount);
                                    contentArea.setText("Funds deducted successfully!\n" +
                                                      "Account: " + (acc.getFullName() != null ? acc.getFullName() : "N/A") + "\n" +
                                                      "Old Balance: $" + String.format("%.2f", oldBalance) + "\n" +
                                                      "Amount Deducted: $" + String.format("%.2f", amount) + "\n" +
                                                      "New Balance: $" + String.format("%.2f", acc.getBalance()));
                                } else {
                                    contentArea.setText("Insufficient funds or invalid amount.");
                                }
                            } catch (NumberFormatException ex) {
                                contentArea.setText("Invalid amount format.");
                            }
                        } else {
                            contentArea.setText("Operation cancelled.");
                        }
                    } else {
                        contentArea.setText("Account not found.");
                    }
                } else {
                    contentArea.setText("Operation cancelled.");
                }
            }
        });

        createAccountBtn.addActionListener(e -> {
            if (currentAdmin != null) {
                String username = JOptionPane.showInputDialog("Enter new username:");
                if (username != null && !username.trim().isEmpty()) {
                    String password = JOptionPane.showInputDialog("Enter password:");
                    if (password != null && !password.trim().isEmpty()) {
                        String fullName = JOptionPane.showInputDialog("Enter full name:");
                        if (fullName != null && !fullName.trim().isEmpty()) {
                            double initialBalance = 10000 + random.nextInt(90000);
                            accounts.put(username, new Account(username, password, fullName, initialBalance));
                            contentArea.setText("New account created!\n" +
                                              "Username: " + username + "\n" +
                                              "Full Name: " + fullName + "\n" +
                                              "Account Number: " + accounts.get(username).getAccountNumber() + "\n" +
                                              "Initial Balance: $" + String.format("%.2f", initialBalance));
                        } else {
                            contentArea.setText("Account creation cancelled.");
                        }
                    } else {
                        contentArea.setText("Account creation cancelled.");
                    }
                } else {
                    contentArea.setText("Account creation cancelled.");
                }
            }
        });

        systemReportBtn.addActionListener(e -> {
            if (currentAdmin != null) {
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

                contentArea.setText("System Report:\n" +
                                  "Total Accounts: " + accountCount + "\n" +
                                  "Active Accounts: " + activeAccounts + "\n" +
                                  "Inactive Accounts: " + (accountCount - activeAccounts) + "\n" +
                                  "Total System Balance: $" + String.format("%.2f", totalBalance) + "\n" +
                                  "Average Balance: $" + String.format("%.2f", totalBalance/accountCount) + "\n" +
                                  "Highest Balance: $" + String.format("%.2f", highestBalance) + "\n" +
                                  "Richest Account: " + richestAccount);
            }
        });

        logoutBtn.addActionListener(e -> {
            currentAdmin = null;
            cardLayout.show(mainPanel, "LOGIN");
            contentArea.setText("");
        });

        return panel;
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