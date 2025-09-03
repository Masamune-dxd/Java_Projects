package $JavaFiles; // Package declaration for organization

import java.util.Scanner; // Import the Scanner class to get user input

public class xPattern {
    public static void main(String[] args) {
        // int rows = 7; // Commented out: This line previously set a fixed number of rows

        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of rows
        System.out.print("Enter the number of rows for the X pattern (odd number recommended): ");
        int rows = scanner.nextInt(); // Read the integer input from the user

        // Close the scanner to prevent resource leaks
        scanner.close();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                // Check if the current position (i, j) is on either diagonal
                if ((i == j) || (j == rows - 1 - i)) {
                    System.out.print("*"); // Print an asterisk if it's on a diagonal
                } else {
                    System.out.print(" "); // Print a space otherwise
                }
            }
            System.out.println(); // Move to the next line after completing a row
        }
    }
}