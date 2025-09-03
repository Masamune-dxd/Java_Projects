package GCashApp;

import java.util.ArrayList;

class CheckBalance {

    ArrayList<Balance> balanceList;

    CheckBalance(ArrayList<Balance> balanceList) {
        this.balanceList = balanceList;
    }

    double checkBalance(int userId) {
        for (Balance balance : balanceList) {
            if (balance.getUserId() == userId) {
                return balance.getAmount();
            }
        }
        return -1.0;
    }

    void displayBalances() {
        System.out.println("\n--- Account Balances ---");
        if (balanceList.isEmpty()) {
            System.out.println("No balances recorded yet.");
            return;
        }
        System.out.printf("%-5s %-15s %-10s\n", "ID", "User ID", "Amount");
        System.out.println("------------------------------");
        for (Balance balance : balanceList) {
            System.out.printf("%-5s %-15s %-10.2f\n",
                    balance.id,
                    balance.userId,
                    balance.amount);
        }
        System.out.println("------------------------------");
    }
}