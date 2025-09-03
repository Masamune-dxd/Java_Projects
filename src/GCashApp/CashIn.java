package GCashApp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class CashIn {

    ArrayList<Balance> balanceList;
    ArrayList<Transaction> transactionList;
    int nextTransactionId;

    CashIn(ArrayList<Balance> balanceList, ArrayList<Transaction> transactionList, int nextTransactionId) {
        this.balanceList = balanceList;
        this.transactionList = transactionList;
        this.nextTransactionId = nextTransactionId;
    }

    void cashIn(int userId, double amount) {
        if (amount <= 0) {
            System.out.println("Cash-in failed: Amount must be positive.");
            return;
        }

        Balance userBalance = null;
        for (Balance balance : balanceList) {
            if (balance.getUserId() == userId) {
                userBalance = balance;
                break;
            }
        }

        if (userBalance == null) {
            System.out.println("Cash-in failed: User ID not found in balance records.");
            return;
        }

        userBalance.setAmount(userBalance.getAmount() + amount);
        System.out.printf("Cash-in successful! User ID %s now has %.2f\n", userId, userBalance.getAmount());

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        Transaction newTransaction = new Transaction(nextTransactionId++, amount, "Cash-in", userId, formattedDateTime, "Cash-in", 0, userId);
        transactionList.add(newTransaction);
    }

    int getNextTransactionId() {
        return nextTransactionId;
    }
}