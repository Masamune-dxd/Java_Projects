package $JavaFiles;

import java.util.ArrayList; // Imports the ArrayList class

class Calculate {
  public static void main(String[] args) {

    // Creates an ArrayList to store expenses
    ArrayList<Double> expenses = new ArrayList<Double>();
    // Adds expense values to the ArrayList
    expenses.add(74.46);
    expenses.add(63.99);
    expenses.add(10.57);
    expenses.add(81.37);

    // Initializes a variable to store the total
    double total = 0;

    // Loops through each expense in the ArrayList
    for (int i = 0; i < expenses.size(); i++) {
      // Adds the current expense to the total
      total += expenses.get(i);
    }

    // Prints the final total
    System.out.println(total);
  }
}

public class CalculateTotal {
  
}