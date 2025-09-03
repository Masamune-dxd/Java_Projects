package GCashApp;

class Transaction {
    int id;
    double amount;
    String name;
    int accountId;
    String date;
    int transferToId;
    int transferFromId;
    String type;

    Transaction(int id, double amount, String name, int accountId, String date, String type, int transferToId, int transferFromId) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.accountId = accountId;
        this.date = date;
        this.type = type;
        this.transferToId = transferToId;
        this.transferFromId = transferFromId;
    }

    int getId() {return id;}
    double getAmount() {return amount;}
    String getName() {return name;}
    int getAccountId() {return accountId;}
    String getDate() {return date;}
    String getType() {return type;}
    int getTransferToId() {return transferToId;}
    int getTransferFromId() {return transferFromId;}
}