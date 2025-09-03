package GCashApp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class CashTransfer {

    ArrayList<Balance> balanceList;
    ArrayList<Transaction> transactionList;
    ArrayList<User> userList;
    int nextTransactionId;

    CashTransfer(ArrayList<Balance> balanceList, ArrayList<Transaction> transactionList, ArrayList<User> userList, int nextTransactionId) {
        this.balanceList = balanceList;
        this.transactionList = transactionList;
        this.userList = userList;
        this.nextTransactionId = nextTransactionId;
    }

    void cashTransfer(int fromUserId, int toUserId, double amount) {
        if (amount <= 0) {
            System.out.println("Cash transfer failed: Amount must be positive.");
            return;
        }
        if (fromUserId == toUserId) {
            System.out.println("Cash transfer failed: Cannot transfer to self.");
            return;
        }

        Balance fromUserBalance = null;
        for (Balance balance : balanceList) {
            if (balance.getUserId() == fromUserId) {
                fromUserBalance = balance;
                break;
            }
        }

        Balance toUserBalance = null;
        for (Balance balance : balanceList) {
            if (balance.getUserId() == toUserId) {
                toUserBalance = balance;
                break;
            }
        }

        if (fromUserBalance == null) {
            System.out.println("Cash transfer failed: Sender user ID not found in balance records.");
            return;
        }
        if (toUserBalance == null) {
            System.out.println("Cash transfer failed: Recipient user ID not found in balance records.");
            return;
        }

        if (fromUserBalance.getAmount() < amount) {
            System.out.println("Cash transfer failed: Insufficient balance.");
            return;
        }

        fromUserBalance.setAmount(fromUserBalance.getAmount() - amount);
        toUserBalance.setAmount(toUserBalance.getAmount() + amount);

        System.out.printf("Cash transfer successful! User ID %s sent %.2f to User ID %s.\n",
                fromUserId, amount, toUserId);
        System.out.printf("Sender (ID %s) new balance: %.2f\n", fromUserId, fromUserBalance.getAmount());
        System.out.printf("Recipient (ID %s) new balance: %.2f\n", toUserId, toUserBalance.getAmount());

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        String fromUserName = "Unknown";
        for (User user : userList) {
            if (user.getId() == fromUserId) {
                fromUserName = user.getName();
                break;
            }
        }

        Transaction fromTransaction = new Transaction(nextTransactionId++, amount, "Transfer Out", fromUserId, formattedDateTime, "Transfer Out", toUserId, fromUserId);
        transactionList.add(fromTransaction);

        Transaction toTransaction = new Transaction(nextTransactionId++, amount, "Transfer In", toUserId, formattedDateTime, "Transfer In", toUserId, fromUserId);
        transactionList.add(toTransaction);
    }

    int getNextTransactionId() {
        return nextTransactionId;
    }
}