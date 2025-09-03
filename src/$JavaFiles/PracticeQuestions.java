package $JavaFiles;

import java.util.*;

public class PracticeQuestions {
    public static void main(String[] args) {
        int x, y, z, sum;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your first number: ");
        x = scan.nextInt();
        System.out.print("Enter your second number: ");
        y = scan.nextInt();
        System.out.print("Enter your third number: ");
        z = scan.nextInt();
        sum = x + y + z;
        System.out.println("The sum of the three numbers is: " + sum);
        scan.close();
    }
}

class helloworld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

class SumOfTheTwoNumbers {
    public static void main(String[] args) {
        int a = 200, b = 300, sum = a+b;
        System.out.println("The sum of " + a + " and " + b + " is " + sum);
    }
}

class EvenOrOdd {
    public static void main(String[] args) {
        int a = 51, b = 122;
        if (a % 2 == 0) {
            System.out.println("Its even");
        } else {
            System.out.println("Its odd");
        }
        if (b % 2 == 0) {
            System.out.println("Its even");
        } else {
            System.out.println("Its odd");
        }

        // with user input
        int x;  
        Scanner scan = new Scanner(System.in);
        System.out.print("Input number: ");
        x = scan.nextInt();
        if (x % 2 ==0) {
            System.out.println("Its even");
        } else {
            System.out.println("Its odd");
        }
        scan.close();
    }
}

class CountingNumbers {
    public static void main(String[] args) {
        int i;
        for (i = 1; i <= 5; i++) {
            System.out.println(i);
        }
    }
}

class StringConcat {
    public static void main(String[] args) {
        String string1 = "Java";
        String string2 = "Programming";
        System.out.println(string1 + " " + string2);
    }
}

class CountWords {
  public static void main(String[] args) {
    String words = "One Two Three Four Five Six Seven Eight Nine Ten";
    int countWords = words.split("\\s").length;
    System.out.println(countWords);
  }
}

class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take input from the user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Call the method to reverse the string
        String reversed = reverseString(input);
        
        // Print the reversed string
        System.out.println("Reversed string: " + reversed);
        
        scanner.close();
    }

    // Method to reverse a string
    public static String reverseString(String str) {
        char[] charArray = str.toCharArray(); // Convert string to char array
        int left = 0; // Start pointer
        int right = charArray.length - 1; // End pointer
        
        // Swap characters until the pointers meet in the middle
        while (left < right) {
            // Swap characters
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            
            // Move the pointers
            left++;
            right--;
        }
        
        // Convert char array back to string
        return new String(charArray);
    }
}


class InterviewProblems {

    // --- Problem 1: Reverse a String without using built-in reverse() methods ---
    public static String reverseString(String str) {
        if (str == null || str.isEmpty()) {
            return str; // Handle null or empty strings
        }

        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            // Swap characters
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Move pointers
            left++;
            right--;
        }

        return new String(charArray);
    }

    // --- Problem 2: Check if a number is a Palindrome ---
    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false; // Negative numbers cannot be palindromes
        }
        if (number < 10) {
            return true; // Single-digit numbers are palindromes
        }

        int originalNumber = number;
        int reversedNumber = 0;

        while (number > 0) {
            int digit = number % 10; // Get the last digit
            reversedNumber = reversedNumber * 10 + digit; // Append digit to reversedNumber
            number /= 10; // Remove the last digit from the original number
        }

        return originalNumber == reversedNumber;
    }

    // --- Problem 3: Find the factorial of a number using recursion ---
    public static long factorial(int n) {
        // Base case: Factorial of 0 or 1 is 1
        if (n == 0 || n == 1) {
            return 1;
        }
        // Handle negative input (factorials are defined for non-negative integers)
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        // Recursive step: n! = n * (n-1)!
        return (long) n * factorial(n - 1); // Cast to long to avoid overflow for larger numbers earlier
    }

    // --- Problem 4: Implement a simple Calculator class ---
    public static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }

        public int multiply(int a, int b) {
            return a * b;
        }

        public double divide(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero!");
            }
            // Cast one of the operands to double to ensure floating-point division
            return (double) a / b;
        }
    }

    // --- Problem 5: Explain the difference between == and .equals() in Java when comparing strings ---
    public static void demonstrateStringComparison() {
        System.out.println("\n--- Problem 5: String Comparison (== vs .equals()) ---");

        // Scenario 1: String Literals (often from the String Pool)
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "world";

        System.out.println("\n--- Comparing String Literals ---");
        System.out.println("String s1 = \"hello\";");
        System.out.println("String s2 = \"hello\";");
        System.out.println("String s3 = \"world\";");
        System.out.println("s1 == s2: " + (s1 == s2) + " (Compares references)"); // Output: true
        System.out.println("s1.equals(s2): " + s1.equals(s2) + " (Compares content)"); // Output: true
        System.out.println("s1 == s3: " + (s1 == s3) + " (Compares references)"); // Output: false
        System.out.println("s1.equals(s3): " + s1.equals(s3) + " (Compares content)"); // Output: false

        // Scenario 2: String objects created using 'new' keyword
        String s4 = new String("hello");
        String s5 = new String("hello");
        String s6 = "hello"; // Literal, potentially from the pool

        System.out.println("\n--- Comparing String Objects created with 'new' ---");
        System.out.println("String s4 = new String(\"hello\");");
        System.out.println("String s5 = new String(\"hello\");");
        System.out.println("String s6 = \"hello\";");
        System.out.println("s4 == s5: " + (s4 == s5) + " (Different objects in memory)"); // Output: false
        System.out.println("s4.equals(s5): " + s4.equals(s5) + " (Content is the same)"); // Output: true
        System.out.println("s4 == s6: " + (s4 == s6) + " (New object vs Pool object)"); // Output: false
        System.out.println("s4.equals(s6): " + s4.equals(s6) + " (Content is the same)"); // Output: true

        // Scenario 3: Mixed (intern() method)
        String s7 = new String("java").intern(); // Explicitly adds to/gets from the pool
        String s8 = "java"; // From the pool

        System.out.println("\n--- Using intern() method ---");
        System.out.println("String s7 = new String(\"java\").intern();");
        System.out.println("String s8 = \"java\";");
        System.out.println("s7 == s8: " + (s7 == s8) + " (Both now refer to the same object in the pool)"); // Output: true
        System.out.println("s7.equals(s8): " + s7.equals(s8) + " (Content is the same)"); // Output: true

        System.out.println("\nSummary:");
        System.out.println("  '==' compares object references (memory addresses).");
        System.out.println("  '.equals()' compares the actual content (value) of the objects.");
        System.out.println("  For String content comparison, ALWAYS use '.equals()'.");
    }

    // --- Main method to run all demonstrations ---
    public static void main(String[] args) {
        System.out.println("--- Problem 1: Reverse a String ---");
        String input1 = "hello";
        System.out.println("Original: " + input1 + ", Reversed: " + reverseString(input1));
        String input2 = "Java";
        System.out.println("Original: " + input2 + ", Reversed: " + reverseString(input2));
        System.out.println("Original: '', Reversed: '" + reverseString("") + "'");
        System.out.println("Original: null, Reversed: " + reverseString(null));

        System.out.println("\n--- Problem 2: Check if a number is a Palindrome ---");
        System.out.println("Is 121 a palindrome? " + isPalindrome(121));
        System.out.println("Is 545 a palindrome? " + isPalindrome(545));
        System.out.println("Is 123 a palindrome? " + isPalindrome(123));
        System.out.println("Is 0 a palindrome? " + isPalindrome(0));
        System.out.println("Is -121 a palindrome? " + isPalindrome(-121));

        System.out.println("\n--- Problem 3: Find the factorial of a number using recursion ---");
        System.out.println("Factorial of 0: " + factorial(0));
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Factorial of 10: " + factorial(10)); // Will be a larger number
        try {
            System.out.println("Factorial of -3: " + factorial(-3));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Problem 4: Implement a simple Calculator class ---");
        Calculator myCalculator = new Calculator();
        System.out.println("10 + 5 = " + myCalculator.add(10, 5));
        System.out.println("10 - 5 = " + myCalculator.subtract(10, 5));
        System.out.println("10 * 5 = " + myCalculator.multiply(10, 5));
        System.out.println("7 / 2 = " + myCalculator.divide(7, 2));
        try {
            System.out.println("10 / 0 = " + myCalculator.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Call the method to demonstrate String comparison
        demonstrateStringComparison();
    }
}