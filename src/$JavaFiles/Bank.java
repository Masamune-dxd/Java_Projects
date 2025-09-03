package $JavaFiles;

public class Bank { 

    public static void main(String[] args) {
        System.out.println("--- Welcome to the Bank Program ---");

        // instances (objects) of CheckingAccount
        CheckingAccount accountOne = new CheckingAccount("Zeus", 100);
        CheckingAccount accountTwo = new CheckingAccount("Hades", 200);
        CheckingAccount myAccount = new CheckingAccount("Mike", 300);

        System.out.println("\n--- Initial Account Information ---");
        myAccount.printBalance();
        accountOne.printBalance();
        accountTwo.printBalance(); // Display initial balance for accountTwo

        System.out.println("\n--- Performing Operations ---");

        // Using myAccount
        System.out.println("Processing for Mike's account (myAccount):");
        myAccount.addFunds(50); // Add funds to myAccount
        myAccount.printBalance();
        myAccount.getInfo(); // Get full info for myAccount

        System.out.println("\nProcessing for Zeus's account (accountOne):");
        accountOne.addFunds(75); // Add funds to accountOne
        accountOne.printBalance();
        accountOne.getInfo(); // Get full info for accountOne

        // *** Making use of accountTwo ***
        System.out.println("\nProcessing for Hades's account (accountTwo):");
        accountTwo.printBalance(); // Show balance before operation
        accountTwo.addFunds(120);  // Add funds to accountTwo
        accountTwo.printBalance(); // Show balance after adding funds
        accountTwo.getInfo();      // Get full info for accountTwo

        System.out.println("\n--- Program Finished ---");
    }
}

class CheckingAccount {
    private String name;
    private int balance;

    // Constructor to initialize name and balance
    public CheckingAccount(String inputName, int inputBalance) {
        name = inputName;
        balance = inputBalance;
        System.out.println("New checking account created for " + name + " with initial balance of " + balance + " dollars.");
    }

    // add funds (public to be callable from Bank class)
    public void addFunds(int fundsToAdd) {
        balance += fundsToAdd;
        System.out.println("SUCCESS: " + fundsToAdd + " dollars added to " + name + "'s account.");
    }

    // print the account balance (public)
    public void printBalance() {
        System.out.println(name + "'s current account balance is " + balance + " dollars.");
    }

    // (public to be callable from Bank class)
    public void getInfo() {
        System.out.println("DETAILS: This checking account belongs to " + name + ". It currently has " + balance + " dollars in it.");
    }
}