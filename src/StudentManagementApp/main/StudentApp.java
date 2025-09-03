package StudentManagementApp.main;

import StudentManagementApp.manager.StudentManager;
import StudentManagementApp.model.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentApp {
    private static final StudentManager manager = new StudentManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Student Management Application!");
        displayMenu();
    }

    private static void displayMenu() {
        int choice;
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Information");
            System.out.println("5. Delete Student");
            System.out.println("6. Get Total Number of Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1;
            }

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Total students registered: " + manager.getNumberOfStudents());
                    break;
                case 0:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    if (choice != 0) { // The default block doesn't explicitly 'break' but control flow falls through
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break; // It's good practice to have a break here too, though often implied for default
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine().trim();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        int age = 0;
        while (true) {
            System.out.print("Enter Age: ");
            String ageInput = scanner.nextLine().trim();
            try {
                age = Integer.parseInt(ageInput);
                if (age > 0) break;
                System.out.println("Age must be a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number for age.");
            }
        }

        System.out.print("Enter Grade (e.g., A, B, C): ");
        String grade = scanner.nextLine().trim();

        Student newStudent = new Student(studentId, name, age, grade);
        manager.addStudent(newStudent);
    }

    private static void searchStudent() {
        System.out.println("\n--- Search Student by ID ---");
        System.out.print("Enter Student ID to search: ");
        String studentId = scanner.nextLine().trim();

        Student foundStudent = manager.findStudentById(studentId);
        if (foundStudent != null) {
            System.out.println("Student Found:");
            System.out.println(foundStudent);
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    private static void updateStudent() {
        System.out.println("\n--- Update Student Information ---");
        System.out.print("Enter Student ID to update: ");
        String studentId = scanner.nextLine().trim();

        Student studentToUpdate = manager.findStudentById(studentId);
        if (studentToUpdate == null) {
            System.out.println("Student with ID " + studentId + " not found. Cannot update.");
            return;
        }

        System.out.println("Current Information: " + studentToUpdate);

        System.out.print("Enter new Name (or press Enter to keep current: " + studentToUpdate.getName() + "): ");
        String newName = scanner.nextLine().trim();
        if (newName.isEmpty()) newName = studentToUpdate.getName();

        int newAge = studentToUpdate.getAge();
        System.out.print("Enter new Age (or press Enter to keep current: " + studentToUpdate.getAge() + "): ");
        String ageInput = scanner.nextLine().trim();
        if (!ageInput.isEmpty()) {
            try {
                int tempAge = Integer.parseInt(ageInput);
                if (tempAge > 0) newAge = tempAge;
                else System.out.println("Invalid age. Keeping current age.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid age input. Keeping current age.");
            }
        }

        System.out.print("Enter new Grade (or press Enter to keep current: " + studentToUpdate.getGrade() + "): ");
        String newGrade = scanner.nextLine().trim();
        if (newGrade.isEmpty()) newGrade = studentToUpdate.getGrade();

        manager.updateStudent(studentId, newName, newAge, newGrade);
    }

    private static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        System.out.print("Enter Student ID to delete: ");
        String studentId = scanner.nextLine().trim();
        manager.deleteStudent(studentId);
    }
}