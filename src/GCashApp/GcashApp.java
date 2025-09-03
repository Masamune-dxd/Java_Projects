package GCashApp;

import java.util.ArrayList;
import java.util.Scanner;

class GCashApp {

    static ArrayList<User> allUsers = new ArrayList<>();
    static ArrayList<Balance> allBalances = new ArrayList<>();
    static ArrayList<Transaction> allTransactions = new ArrayList<>();
    static int currentNextUserId = 1;
    static int currentNextBalanceId = 1;
    static int currentNextTransactionId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAuthentication auth = new UserAuthentication(allUsers, currentNextUserId);
        CheckBalance checkBalance = new CheckBalance(allBalances);
        CashIn cashIn = new CashIn(allBalances, allTransactions, currentNextTransactionId);
        CashTransfer cashTransfer = new CashTransfer(allBalances, allTransactions, allUsers, currentNextTransactionId);
        ViewTransaction viewTransaction = new ViewTransaction(allTransactions);

        System.out.println();
        System.out.println("=========================================");
        System.out.println("          Welcome to GCashApp           ");
        System.out.println("=========================================");
        System.out.println();
        
        System.out.println("\n--- Initial Setup: Registering Users ---");
        int user1Id = auth.registration("Eula Lawrence", "eulasthiccsavings@gmail.com", "09171234567", "1234");
        int user2Id = auth.registration("Diesel", "dieselscandyl@gmail.com", "09987654321", "5678");
        auth.registration("Tsukishiro Yanagi", "secretaryyanagi@gmail.com", "09171234567", "9876");
        auth.registration("Topaz", "iamtopaz69@gmail.com", "09151234567", "4321");
        currentNextUserId = auth.getNextUserId();
        System.out.println();
        

        auth.displayUsers();

        System.out.println("\n--- Initial Setup: Adding Dummy Balances ---");
        if (user1Id != -1) {
            allBalances.add(new Balance(currentNextBalanceId++, 1500.75, user1Id));
        }
        if (user2Id != -1) {
            allBalances.add(new Balance(currentNextBalanceId++, 500.00, user2Id));
        }
        if (allUsers.size() > 2 && allUsers.get(2).getId() != -1) {
             allBalances.add(new Balance(currentNextBalanceId++, 100.00, allUsers.get(2).getId())); 
        }
        if (allUsers.size() > 3 && allUsers.get(3).getId() != -1) {
             allBalances.add(new Balance(currentNextBalanceId++, 2000.00, allUsers.get(3).getId())); 
        }
        checkBalance.displayBalances();

        int loggedInUserId = -1;
        while (loggedInUserId == -1) {
            System.out.println("\n--- Login to Continue ---");
            System.out.print("Enter your Email or Phone Number: ");
            String identifier = scanner.nextLine();
            System.out.print("Enter your PIN: ");
            String pin = scanner.nextLine();
            loggedInUserId = auth.login(identifier, pin);
            if (loggedInUserId == -1) {
                System.out.println("Please try again.");
            }
        }

        String wantsAnotherTransaction = "yes";
        while (wantsAnotherTransaction.equalsIgnoreCase("yes") || wantsAnotherTransaction.equalsIgnoreCase("y")) {
            System.out.println("\n--- Available Transactions ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Cash-in");
            System.out.println("3. Cash Transfer");
            System.out.println("4. View All Transactions for My Account");
            System.out.println("5. Change PIN");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    double balance = checkBalance.checkBalance(loggedInUserId);
                    if (balance != -1.0) {
                        System.out.printf("Your current balance: %.2f\n", balance);
                    } else {
                        System.out.println("Balance information not available.");
                    }
                    break;
                case "2":
                    System.out.print("Enter amount to cash-in: ");
                    try {
                        double amountIn = Double.parseDouble(scanner.nextLine());
                        cashIn.cashIn(loggedInUserId, amountIn);
                        currentNextTransactionId = cashIn.getNextTransactionId();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount. Please enter a number.");
                    }
                    break;
                case "3":
                    System.out.print("Enter recipient User ID: ");
                    try {
                        int recipientId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = Double.parseDouble(scanner.nextLine());
                        cashTransfer.cashTransfer(loggedInUserId, recipientId, transferAmount);
                        currentNextTransactionId = cashTransfer.getNextTransactionId();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter numbers for ID and amount.");
                    }
                    break;
                case "4":
                    viewTransaction.viewUserTransactions(loggedInUserId);
                    break;
                case "5":
                    System.out.print("Enter old PIN: ");
                    String oldPin = scanner.nextLine();
                    System.out.print("Enter new PIN (4 digits): ");
                    String newPin = scanner.nextLine();
                    auth.changePin(loggedInUserId, oldPin, newPin);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.print("Do you want to perform another transaction? (yes/no): ");
            wantsAnotherTransaction = scanner.nextLine();
        }

        auth.logout(loggedInUserId);
        System.out.println("Thank you for using GCashApp!");

        scanner.close();
    }
}