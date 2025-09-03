package LoginRegistration;

import java.io.*;
import java.util.Scanner;

public class LoginRegistration {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("\n\t\t\t Please enter your choice: ");
            while (!sc.hasNextInt()) {
                System.out.print("\t\t\t Invalid input. Please enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    login(sc);
                    break;
                case 2:
                    registration(sc);
                    break;
                case 3:
                    forgot(sc);
                    break;
                case 4:
                    System.out.println("\t\t\t Thank you! \n");
                    break;
                default:
                    System.out.println("\t\t\t Please select from the options given above \n");
            }
        } while (choice != 4);
        sc.close();
    }

    public static void displayMenu() {
        System.out.println("\t\t\t ____________________________________________\n\n\n");
        System.out.println("\t\t\t          Welcome to login page              \n\n\n");
        System.out.println("\t\t\t _____________     MENU      ________________\n\n\n");
        System.out.println("\t\t\t | Press 1 to LOGIN                        |");
        System.out.println("\t\t\t | Press 2 to REGISTER                     |");
        System.out.println("\t\t\t | Press 3 if you forgot your PASSWORD     |");
        System.out.println("\t\t\t | Press 4 to EXIT                         |");
    }

    public static void login(Scanner sc) {
        int count = 0;
        String userId, password;

        clearScreen();

        System.out.print("\t\t\t Please enter the username and password:\n");
        System.out.print("\t\t\t USERNAME: ");
        userId = sc.next();
        System.out.print("\t\t\t PASSWORD: ");
        password = sc.next();

        try (BufferedReader reader = new BufferedReader(new FileReader("records.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] creds = line.split(" ");
                if (creds.length == 2 && creds[0].equals(userId) && creds[1].equals(password)) {
                    count = 1;
                    clearScreen();
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error: Could not open records.txt for reading.");
            return;
        }

        if (count == 1) {
            System.out.println(userId + "\n Your LOGIN is successful. \n Thanks for logging in! \n");
        } else {
            System.out.println("\n LOGIN ERROR \n Please check your username and password.\n");
        }
    }

    public static void registration(Scanner sc) {
        String registerUserId, registerPassword;
        clearScreen();

        System.out.print("\t\t\t Enter your username: ");
        registerUserId = sc.next();
        System.out.print("\t\t\t Enter your password: ");
        registerPassword = sc.next();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("records.txt", true))) {
            writer.write(registerUserId + " " + registerPassword);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error: Could not open records.txt for appending.");
            return;
        }

        clearScreen();
        System.out.println("\n\t\t\t Registration is successful! \n");
    }

    public static void forgot(Scanner sc) {
        int option;
        clearScreen();
        System.out.println("\t\t\t Forgot Password? ");
        System.out.println("Press 1 to search your ID by username ");
        System.out.println("Press 2 to go back to the main menu ");
        System.out.print("\t\t\t Enter your choice: ");
        while (!sc.hasNextInt()) {
            System.out.print("\t\t\t Invalid input. Please enter a number: ");
            sc.next();
        }
        option = sc.nextInt();

        switch (option) {
            case 1: {
                int count = 0;
                String searchUserId;
                System.out.print("\n\t\t\t Enter the username you remember: ");
                searchUserId = sc.next();

                String foundPassword = null;
                try (BufferedReader reader = new BufferedReader(new FileReader("records.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] creds = line.split(" ");
                        if (creds.length == 2 && creds[0].equals(searchUserId)) {
                            count = 1;
                            foundPassword = creds[1];
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error: Could not open records.txt for reading.");
                    return;
                }
                if (count == 1) {
                    System.out.println("\n\n Your account is found! ");
                    System.out.println(" \n\n Your password is: " + foundPassword);
                } else {
                    System.out.println("\n\t Sorry we can't find your account. ");
                }
                break;
            }
            case 2:
                // Do nothing, just return to main menu.
                break;
            default:
                System.out.println("\t\t\t Wrong choice! Try again");
                forgot(sc); // Recursive call for valid input
        }
    }

    // Utility method to simulate clear screen in console
    public static void clearScreen() {
        // Not portable, but can help with Windows and UNIX-like systems.
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (Exception e) {
            // Do nothing, just don't clear the screen
        }
    }
}

// End of file
// mazamunexd
// Masamune-dxd