package $JavaFiles;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;
// import java.util.HashMap;
// import java.util.*;

public class TestGcashApp {
    private static String validEmail = "user@example.com";
    private static String validPassword = "password123";
    private static double userBalance = 1000.00;
    private static double user2Balance = 500.00;
    private static StringBuilder transactionLog = new StringBuilder();

    // user login authentication
    static class UserAuthentication {
        // Checks if the email and password are correct
        public boolean login(String email, String password) {
            return validEmail.equals(email) && validPassword.equals(password);
        }
    }

    // check a user's balance
    static class CheckBalance {
        // Returns the balance for a given user
        public double getBalance(String userId) {
            if ("user1".equals(userId)) return userBalance;
            if ("user2".equals(userId)) return user2Balance;
            return 0.0;
        }
    }

    // user1 deposit money
    static class CashIn {
        // Adds money to user1's balance if amount is positive
        public boolean deposit(String userId, double amount) {
            if (amount > 0 && "user1".equals(userId)) {
                userBalance += amount;
                transactionLog.append("CashIn: User1 deposited ").append(amount).append("\n");
                return true;
            }
            return false;
        }
    }

    // user1 send money to user2
    static class CashTransfer {
        // Transfers money from user1 to user2 if enough balance
        public boolean transfer(String senderId, String receiverId, double amount) {
            if (amount > 0 && "user1".equals(senderId) && userBalance >= amount) {
                userBalance -= amount;
                user2Balance += amount;
                transactionLog.append("CashTransfer: User1 to User2, amount ").append(amount).append("\n");
                return true;
            }
            return false;
        }
    }

    // shows transactions , demo only
    static class Transactions {
        // Returns the transaction log as a string
        public String getTransactions(String userId) {
            return transactionLog.toString();
        }
    }

    // runs simple tests and prints results in a table 
    static class GcashAppTester {
        // Prints the table header for a test category
        private void printHeader(String testCategory) {
            System.out.println();
            System.out.println("+--------------------------------+----------+------------+");
            System.out.printf("| %-30s | %-8s | %-10s |\n", ("TESTING: " + testCategory), "", "");
            System.out.println("+--------------------------------+----------+------------+");
            System.out.printf("| %-30s | %-8s | %-10s |\n", "Test Name", "Result", "Details");
            System.out.println("+--------------------------------+----------+------------+");
        }

        // prints a single test result row
        private void printTestResult(String testName, boolean success, String details) {
            System.out.printf("| %-30s | %-8s | %-10s |\n", testName, (success ? "PASS" : "FAIL"), details);
        }

        // runs all test categories
        public void testAll() {
            printHeader("User Authentication");
            testUserAuthentication();
            printHeader("Check Balance");
            testCheckBalance();
            printHeader("Cash In");
            testCashIn();
            printHeader("Cash Transfer");
            testCashTransfer();
            printHeader("Transactions");
            testTransactions();
        }

        // tests login 
        private void testUserAuthentication() {
            UserAuthentication auth = new UserAuthentication();
            printTestResult("Valid Login", auth.login(validEmail, validPassword), "Should PASS");
            printTestResult("Wrong Password", !auth.login(validEmail, "wrongpass"), "Should FAIL");
            printTestResult("Wrong Email", !auth.login("wrong@example.com", validPassword), "Should FAIL");
        }

        // tests balance checking for users
        private void testCheckBalance() {
            CheckBalance cb = new CheckBalance();
            printTestResult("User1 Balance", cb.getBalance("user1") == userBalance, "" + userBalance);
            printTestResult("User2 Balance", cb.getBalance("user2") == user2Balance, "" + user2Balance);
            printTestResult("Unknown User", cb.getBalance("unknown") == 0.0, "0.0");
        }

        // tests depositing money
        private void testCashIn() {
            CashIn ci = new CashIn();
            double before = userBalance;
            boolean deposit = ci.deposit("user1", 200.00);
            printTestResult("Deposit 200", deposit && userBalance == before + 200.00, "" + userBalance);
            printTestResult("Negative Deposit", !ci.deposit("user1", -50.00), "Should FAIL");
        }

        // tests transferring money between users
        private void testCashTransfer() {
            CashTransfer ct = new CashTransfer();
            double before1 = userBalance;
            double before2 = user2Balance;
            boolean transfer = ct.transfer("user1", "user2", 100.00);
            boolean ok1 = userBalance == before1 - 100.00;
            boolean ok2 = user2Balance == before2 + 100.00;
            printTestResult("Transfer 100", transfer && ok1 && ok2, "U1: " + userBalance + ", U2: " + user2Balance);
            printTestResult("Insufficient Balance", !ct.transfer("user1", "user2", userBalance + 1.00), "Should FAIL");
        }

        // tests if transactions are shown correctly
        private void testTransactions() {
            Transactions tx = new Transactions();
            String logs = tx.getTransactions("user1");
            boolean hasCashIn = logs.contains("CashIn");
            boolean hasTransfer = logs.contains("CashTransfer");
            printTestResult("Show Transactions", hasCashIn && hasTransfer, "See logs");
            System.out.println("\nTransaction Log:\n" + logs);
        }
    }

    // program entry point: runs all tests
    public static void main(String[] args) {
        GcashAppTester tester = new GcashAppTester();
        tester.testAll();
    }
}
