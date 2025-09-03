package $JavaFiles;

import java.util.Scanner;

public class DiamondPatterns {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Let's draw some diamond patterns!");
        System.out.print("Enter an integer for the diamond's height (odd number recommended for symmetry): ");
        int size = inputScanner.nextInt();
        inputScanner.close();

        // Ensure 'size' is odd for better symmetry in diamond patterns
        if (size % 2 == 0) {
            size++; // Increment to make it odd
            System.out.println("Adjusting size to " + size + " for better symmetry.");
        }

        // --- Filled Diamond Pattern ---
        System.out.println("\n--- Filled Diamond ---");
        // Upper part of the filled diamond (including the middle row)
        for (int i = 1; i <= size; i += 2) {
            // Print leading spaces
            for (int spaceCount = 1; spaceCount <= (size - i) / 2; spaceCount++) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int starCount = 1; starCount <= i; starCount++) {
                System.out.print("*");
            }
            System.out.println(); // New line after each row
        }

        // Lower part of the filled diamond
        for (int i = size - 2; i >= 1; i -= 2) {
            // Print leading spaces
            for (int spaceCount = 1; spaceCount <= (size - i) / 2; spaceCount++) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int starCount = 1; starCount <= i; starCount++) {
                System.out.print("*");
            }
            System.out.println(); // New line after each row
        }

        // --- Unfilled (Hollow) Diamond Pattern ---
        System.out.println("\n--- Unfilled (Hollow) Diamond ---");
        // Upper part of the unfilled diamond (including the middle row)
        for (int i = 1; i <= size; i += 2) {
            // Print leading spaces
            for (int spaceCount = 1; spaceCount <= (size - i) / 2; spaceCount++) {
                System.out.print(" ");
            }
            // Print asterisks or spaces for the hollow effect
            for (int starCount = 1; starCount <= i; starCount++) {
                if (starCount == 1 || starCount == i) { // Only print '*' at the edges
                    System.out.print("*");
                } else {
                    System.out.print(" "); // Print space in between
                }
            }
            System.out.println(); // New line after each row
        }

        // Lower part of the unfilled diamond
        for (int i = size - 2; i >= 1; i -= 2) {
            // Print leading spaces
            for (int spaceCount = 1; spaceCount <= (size - i) / 2; spaceCount++) {
                System.out.print(" ");
            }
            // Print asterisks or spaces for the hollow effect
            for (int starCount = 1; starCount <= i; starCount++) {
                if (starCount == 1 || starCount == i) { // Only print '*' at the edges
                    System.out.print("*");
                } else {
                    System.out.print(" "); // Print space in between
                }
            }
            System.out.println(); // New line after each row
        }
    }
}