package GCashApp;

import java.util.ArrayList;

class ViewTransaction {

    ArrayList<Transaction> transactionList;

    ViewTransaction(ArrayList<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    void viewAllTransactions() {
        System.out.println("\n--- All Transactions ---");
        if (transactionList.isEmpty()) {
            System.out.println("No transactions recorded yet.");
            return;
        }
        System.out.printf("%-5s %-12s %-15s %-15s %-20s %-12s %-12s %-12s\n",
                "ID", "Amount", "Name", "Account ID", "Date", "Type", "To ID", "From ID");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (Transaction transaction : transactionList) {
            System.out.printf("%-5s %-12.2f %-15s %-15s %-20s %-12s %-12s %-12s\n",
                    transaction.getId(),
                    transaction.getAmount(),
                    transaction.getName(),
                    transaction.getAccountId(),
                    transaction.getDate(),
                    transaction.getType(),
                    transaction.getTransferToId() == 0 ? "N/A" : transaction.getTransferToId(),
                    transaction.getTransferFromId() == 0 ? "N/A" : transaction.getTransferFromId());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }

    void viewUserTransactions(int userId) {
        System.out.println("\n--- Transactions for User ID: " + userId + " ---");
        boolean found = false;
        System.out.printf("%-5s %-12s %-15s %-15s %-20s %-12s %-12s %-12s\n",
                "ID", "Amount", "Name", "Account ID", "Date", "Type", "To ID", "From ID");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (Transaction transaction : transactionList) {
            if (transaction.getAccountId() == userId || transaction.getTransferToId() == userId || transaction.getTransferFromId() == userId) {
                System.out.printf("%-5s %-12.2f %-15s %-15s %-20s %-12s %-12s %-12s\n",
                        transaction.getId(),
                        transaction.getAmount(),
                        transaction.getName(),
                        transaction.getAccountId(),
                        transaction.getDate(),
                        transaction.getType(),
                        transaction.getTransferToId() == 0 ? "N/A" : transaction.getTransferToId(),
                        transaction.getTransferFromId() == 0 ? "N/A" : transaction.getTransferFromId());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No transactions found for User ID " + userId);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }

    void viewTransactionById(int transactionId) {
        System.out.println("\n--- Transaction Details for ID: " + transactionId + " ---");
        boolean found = false;
        System.out.printf("%-5s %-12s %-15s %-15s %-20s %-12s %-12s %-12s\n",
                "ID", "Amount", "Name", "Account ID", "Date", "Type", "To ID", "From ID");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (Transaction transaction : transactionList) {
            if (transaction.getId() == transactionId) {
                System.out.printf("%-5s %-12.2f %-15s %-15s %-20s %-12s %-12s %-12s\n",
                        transaction.getId(),
                        transaction.getAmount(),
                        transaction.getName(),
                        transaction.getAccountId(),
                        transaction.getDate(),
                        transaction.getType(),
                        transaction.getTransferToId() == 0 ? "N/A" : transaction.getTransferToId(),
                        transaction.getTransferFromId() == 0 ? "N/A" : transaction.getTransferFromId());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No transaction found with ID " + transactionId);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }
}