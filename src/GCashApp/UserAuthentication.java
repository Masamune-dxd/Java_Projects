package GCashApp;

import java.util.ArrayList;
import java.util.regex.Pattern;

class UserAuthentication {

    ArrayList<User> userList;
    int nextUserId;

    UserAuthentication(ArrayList<User> userList, int nextUserId) {
        this.userList = userList;
        this.nextUserId = nextUserId;
    }

    int registration(String name, String email, String number, String pin) {
        if (!validateField(name, "name") || !validateField(email, "email") ||
            !validateField(number, "number") || !validateField(pin, "pin")) {
            System.out.println("Registration failed: Invalid input.");
            return -1;
        }

        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                System.out.println("Registration failed: Email already exists.");
                return -1;
            }
            if (user.getNumber().equals(number)) {
                System.out.println("Registration failed: Phone number already exists.");
                return -1;
            }
        }

        User newUser = new User(nextUserId, name, email, number, pin);
        userList.add(newUser);
        System.out.println("User " + name + " registered successfully with ID: " + nextUserId);
        return nextUserId++;
    }

    boolean validateField(String value, String type) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println(type + " cannot be empty.");
            return false;
        }

        switch (type) {
            case "name":
                if (!Pattern.matches("^[a-zA-Z\\s]+$", value)) {
                    System.out.println("Invalid name format. Use only letters and spaces.");
                    return false;
                }
                break;
            case "email":
                if (!Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", value)) {
                    System.out.println("Invalid email format.");
                    return false;
                }
                break;
            case "number":
                if (!Pattern.matches("^\\d{10,15}$", value)) {
                    System.out.println("Invalid number format. Must be 10-15 digits.");
                    return false;
                }
                break;
            case "pin":
                if (!Pattern.matches("^\\d{4}$", value)) {
                    System.out.println("Invalid PIN format. Must be exactly 4 digits.");
                    return false;
                }
                break;
            default:
                break;
        }
        return true;
    }

    int login(String identifier, String pin) {
        if (identifier == null || identifier.trim().isEmpty()) {
            System.out.println("Login failed: Identifier cannot be empty.");
            return -1;
        }
        if (pin == null || pin.trim().isEmpty()) {
            System.out.println("Login failed: PIN cannot be empty.");
            return -1;
        }

        for (User user : userList) {
            if ((user.getEmail().equals(identifier) || user.getNumber().equals(identifier)) &&
                user.getPin().equals(pin)) {
                System.out.println("Login successful for user: " + user.getName());
                return user.getId();
            }
        }
        System.out.println("Login failed: Incorrect identifier or PIN.");
        return -1;
    }

    boolean changePin(int userId, String oldPin, String newPin) {
        User targetUser = null;
        for (User user : userList) {
            if (user.getId() == userId) {
                targetUser = user;
                break;
            }
        }

        if (targetUser == null) {
            System.out.println("Change PIN failed: User not found.");
            return false;
        }
        if (!targetUser.getPin().equals(oldPin)) {
            System.out.println("Change PIN failed: Incorrect old PIN.");
            return false;
        }
        if (!validateField(newPin, "pin")) {
            System.out.println("Change PIN failed: Invalid new PIN format.");
            return false;
        }

        targetUser.setPin(newPin);
        System.out.println("PIN for user ID " + userId + " changed successfully.");
        return true;
    }

    void logout(int userId) {
        System.out.println("User ID " + userId + " logged out successfully.");
    }

    void displayUsers() {
        System.out.println("\n--- Registered Users ---");
        if (userList.isEmpty()) {
            System.out.println("No users registered yet.");
            return;
        }
        System.out.printf("%-5s %-15s %-25s %-15s %-5s\n", "ID", "Name", "Email", "Number", "PIN");
        System.out.println("----------------------------------------------------------------------");
        for (User user : userList) {
            System.out.printf("%-5s %-15s %-25s %-15s %-5s\n",
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getNumber(),
                    user.getPin());
        }
        System.out.println("----------------------------------------------------------------------");
    }

    int getNextUserId() {
        return nextUserId;
    }
}