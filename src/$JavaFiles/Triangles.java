package $JavaFiles;

import java.util.Scanner;

public class Triangles {
    public static void main(String[] args) {
        // SECTION 1: Multiplication Table (1 to 10)
        /* 
        System.out.println("Multiplication Table:");
        System.out.println("---------------------");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
        */

        // SECTION 2: Right-Angled Triangle (User Input)
        System.out.println("\nRight-Angled Triangle Pattern:");
        System.out.println("-----------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();

        // Print right-angled triangle with n rows
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // SECTION 3: Pyramid Pattern (Fixed Size)
        System.out.println("\nPyramid Pattern:");
        System.out.println("----------------");
        int x = 10; // Number of rows for the pyramid
        for (int i = 1; i <= x; i++) {
            // Print spaces
            for (int j = x - i; j > 0; j--) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // SECTION 4: Right-Aligned Triangle (Fixed Size)
        System.out.println("\nRight-Aligned Triangle Pattern:");
        System.out.println("-------------------------------");
        int y = 10; // Number of rows for the triangle
        for (int i = 1; i <= y; i++) {
            // Print spaces
            for (int j = y - i; j > 0; j--) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // SECTION 5: Upside-Down Right-Angled Triangle (User Input)
        System.out.println("\nUpside-Down Right-Angled Triangle Pattern:");
        System.out.println("------------------------------------------");
        // Uses the same 'n' from earlier input
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // SECTION 6: Upside-Down Pyramid Pattern (Fixed Size)
        System.out.println("\nUpside-Down Pyramid Pattern:");
        System.out.println("----------------------------");
        for (int i = x; i >= 1; i--) {
            // Print spaces
            for (int j = x - i; j > 0; j--) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // SECTION 7: Upside-Down Right-Aligned Triangle (Fixed Size)
        System.out.println("\nUpside-Down Right-Aligned Triangle Pattern:");
        System.out.println("-------------------------------------------");
        for (int i = y; i >= 1; i--) {
            // Print spaces
            for (int j = y - i; j > 0; j--) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}