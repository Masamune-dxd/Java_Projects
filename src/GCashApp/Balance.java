package GCashApp;

class Balance {
    int id;
    double amount;
    int userId;

    Balance(int id, double amount, int userId) {
        this.id = id;
        this.amount = amount;
        this.userId = userId;
    }

    double getAmount() {
        return amount;
    }

    void setAmount(double amount) {
        this.amount = amount;
    }

    int getUserId() {
        return userId;
    }
}