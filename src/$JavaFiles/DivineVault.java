package $JavaFiles;

public class DivineVault { 
  private AccountHolder accountOne; 
  private AccountHolder accountTwo; 

  public DivineVault() { 
    accountOne = new AccountHolder("Zeus", 100, "1"); 
    accountTwo = new AccountHolder("Hades", 200, "2"); 
  }

  public static void main(String[] args) { 
    DivineVault bankOfGods = new DivineVault();

    System.out.println("Account Holder: " + bankOfGods.accountOne.getName() + " (ID: " + bankOfGods.accountOne.getId() + ")"); 
    System.out.println("Initial Balance: " + bankOfGods.accountOne.getBalance()); 

    bankOfGods.accountOne.setBalance(5000); 
    System.out.println("New Balance: " + bankOfGods.accountOne.getBalance()); 
    System.out.println("Monthly Interest: " + bankOfGods.accountOne.getMonthlyInterest()); 

    System.out.println("\n--- Hades' Account ---"); 
    System.out.println("Account Holder: " + bankOfGods.accountTwo.getName() + " (ID: " + bankOfGods.accountTwo.getId() + ")");
    System.out.println("Balance: " + bankOfGods.accountTwo.getBalance()); 
  }
}

class AccountHolder { 
  private String name; 
  private int balance; 
  private String id; 
  private double interestRate; 

  public AccountHolder(String inputName, int inputBalance, String inputId) { 
    this.name = inputName; 
    this.balance = inputBalance; 
    this.id = inputId; 
    this.interestRate = 0.02; 
  }

  public int getBalance() { 
    return this.balance; 
  }

  public void setBalance(int newBalance) { 
    this.balance = newBalance; 
  }

  public double getMonthlyInterest() {
    return this.interestRate * this.balance; 
  }

  public String getName() {
    return this.name; 
  }

  public String getId() { 
    return this.id; 
  }
}