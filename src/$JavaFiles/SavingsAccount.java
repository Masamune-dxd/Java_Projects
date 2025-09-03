package $JavaFiles;

public class SavingsAccount {
  // Instance variables for account details
  public String owner;
  public double balanceDollar;
  public double balanceEuro;

  // Constructor to initialize the account
  public SavingsAccount(String owner, double balanceDollar) {
    this.owner = owner;
    this.balanceDollar = balanceDollar;
    this.balanceEuro = balanceDollar * 0.85; // Converts initial dollar balance to euro
  }

  // Method to add money to the account
  public void addMoney(int balanceDollar) {
    System.out.println("Adding " + balanceDollar + " dollars to the account.");
    this.balanceDollar += balanceDollar; // Updates dollar balance
    System.out.println("The new balance is " + this.balanceDollar + " dollars.");
  }

  public static void main(String[] args) {
    // Creates a new SavingsAccount object
    SavingsAccount zeusSavingsAccount = new SavingsAccount("Zeus", 1000);

    // Calls the addMoney method
    zeusSavingsAccount.addMoney(2000);
  }
}