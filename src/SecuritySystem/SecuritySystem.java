package SecuritySystem;

import java.io.*;
import java.util.*;

public class SecuritySystem {
    static Scanner scanner = new Scanner(System.in);

    // Helper to clear the input buffer (not really needed in Java)
    static void clearInputBuffer() {
        // No direct equivalent needed in Java when using Scanner with nextLine()
    }

    public static void main(String[] args) {
        int choice;
        String username, password, newPassword1, newPassword2, age;
        String storedUsername, storedPassword, storedAge;

        System.out.println("         Security System ");
        System.out.println(" ______________________________\n");
        System.out.println("|         1. Register          |");
        System.out.println("|         2. Login             |");
        System.out.println("|         3. Change password   |");
        System.out.println("|_________4. End Program_______|\n");

        do {
            System.out.print("\n\nEnter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Enter a valid choice: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // clear input buffer

            switch (choice) {
                case 1:
                    System.out.println("___________________________\n");
                    System.out.println("|--------Register---------|");
                    System.out.println("|_________________________|\n");
                    System.out.print("Please enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    password = scanner.nextLine();
                    System.out.print("Please enter your age: ");
                    age = scanner.nextLine();

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true))) {
                        writer.write(username + "\n");
                        writer.write(password + "\n");
                        writer.write(age + "\n");
                        System.out.println("Registration Successful.");
                    } catch (IOException e) {
                        System.out.println("Error opening file for registration.");
                    }
                    break;

                case 2:
                    System.out.println("___________________________\n");
                    System.out.println("|---------Login-----------|");
                    System.out.println("|_________________________|\n");
                    System.out.print("Please enter your username: ");
                    username = scanner.nextLine();
                    System.out.print("Please enter your password: ");
                    password = scanner.nextLine();

                    boolean loggedIn = false;
                    try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
                        while ((storedUsername = reader.readLine()) != null) {
                            storedPassword = reader.readLine();
                            storedAge = reader.readLine();
                            if (username.equals(storedUsername) && password.equals(storedPassword)) {
                                System.out.println("---Login successful---\n");
                                System.out.println("Details: ");
                                System.out.println("Username: " + username);
                                System.out.println("Password: " + password);
                                System.out.println("Age: " + storedAge);
                                loggedIn = true;
                                break;
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Error opening file for login.");
                    }
                    if (!loggedIn) {
                        System.out.println("\n\nIncorrect Credentials");
                        System.out.println("|   1. Press 2 to login              |");
                        System.out.println("|   2. Press 3 to change password    |");
                    }
                    break;

                case 3:
                    System.out.println("-------------Change password-------------");
                    System.out.print("Enter your current username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter your old password: ");
                    password = scanner.nextLine();

                    List<String[]> users = new ArrayList<>();
                    boolean foundUser = false;

                    // Read all users
                    try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
                        while ((storedUsername = reader.readLine()) != null) {
                            storedPassword = reader.readLine();
                            storedAge = reader.readLine();
                            if (username.equals(storedUsername) && password.equals(storedPassword)) {
                                foundUser = true;
                                users.add(new String[]{storedUsername, null, storedAge}); // placeholder for new password
                            } else {
                                users.add(new String[]{storedUsername, storedPassword, storedAge});
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file.");
                    }

                    if (foundUser) {
                        System.out.print("Enter your new password: ");
                        newPassword1 = scanner.nextLine();
                        System.out.print("Re-enter your new password: ");
                        newPassword2 = scanner.nextLine();
                        if (newPassword1.equals(newPassword2)) {
                            // Write users back to file with updated password
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"))) {
                                for (String[] user : users) {
                                    writer.write(user[0] + "\n");
                                    if (user[1] == null) {
                                        writer.write(newPassword1 + "\n");
                                    } else {
                                        writer.write(user[1] + "\n");
                                    }
                                    writer.write(user[2] + "\n");
                                }
                                System.out.println("Password changed successfully.");
                            } catch (IOException e) {
                                System.out.println("Error writing file.");
                            }
                        } else {
                            System.out.println("New passwords do not match.");
                        }
                    } else {
                        System.out.println("Incorrect username or old password.");
                    }
                    break;

                case 4:
                    System.out.println("____________Thank you___________");
                    break;

                default:
                    System.out.println("Enter a valid choice.");
            }
        } while (choice != 4);
    }
}

// End of file
// mazamunexd
// Masamune-dxd