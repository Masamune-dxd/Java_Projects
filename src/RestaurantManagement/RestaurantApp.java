package RestaurantManagement;

import java.util.Scanner;
import java.util.List;
import java.time.LocalDateTime;
import java.util.InputMismatchException;

public class RestaurantApp {
    private MenuManager menuManager;
    private TableManager tableManager;
    private Scanner scanner;

    public RestaurantApp() {
        this.menuManager = new MenuManager();
        this.tableManager = new TableManager();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (choice) {
                    case 1:
                        makeReservation();
                        break;
                    case 2:
                        placeOrder();
                        break;
                    case 3:
                        displayTables(tableManager.getTables());
                        break;
                    case 4:
                        System.out.println("Thank you for using our app. Goodbye!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
            System.out.println(); // Add a blank line for readability
        }
        scanner.close();
    }

    private void displayMainMenu() {
        System.out.println("--- Restaurant App CLI ---");
        System.out.println("1. Make a Reservation");
        System.out.println("2. Place a Walk-in Order");
        System.out.println("3. View Table Status");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void makeReservation() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        final int[] guests = {0};
        while (true) {
            System.out.print("Enter number of guests: ");
            try {
                int inputGuests = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (inputGuests <= 0) {
                    System.out.println("Number of guests must be positive.");
                    continue;
                }
                guests[0] = inputGuests;
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        tableManager.findAvailableTable(guests[0]).ifPresentOrElse(
            availableTable -> {
                LocalDateTime reservationTime = LocalDateTime.now().plusHours(1);
                availableTable.setAvailable(false); // Mark the table as reserved
                Reservation newReservation = new Reservation(name, guests[0], reservationTime, availableTable);
                System.out.println("\nReservation successful!");
                displayReservations(List.of(newReservation));
            },
            () -> System.out.println("Sorry, no available tables for that many guests.")
        );
    }

    private void placeOrder() {
        displayMenu(menuManager.getMenuItems());
        Order newOrder = new Order();
        boolean ordering = true;
        while (ordering) {
            try {
                System.out.print("Enter menu item ID to add to order (0 to finish): ");
                int itemId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (itemId == 0) {
                    ordering = false;
                    continue;
                }

                menuManager.getMenuItemById(itemId).ifPresentOrElse(
                    item -> {
                        newOrder.addItem(item);
                        System.out.println(item.getName() + " added to order.");
                    },
                    () -> System.out.println("Invalid menu item ID. Please try again.")
                );
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        System.out.println("\n--- Your Order ---");
        displayOrder(newOrder);
        System.out.println("------------------");
    }

    // Display tables in a clean table format
    public static void displayTables(List<Table> tables) {
        String leftAlignFormat = "| %-10s | %-10s | %-10s |%n";
        System.out.format("+------------+------------+------------+%n");
        System.out.format("| Table No.  | Capacity   | Reserved   |%n");
        System.out.format("+------------+------------+------------+%n");
        for (Table table : tables) {
            System.out.format(leftAlignFormat,
                table.getTableNumber(),
                table.getCapacity(),
                table.isAvailable() ? "No" : "Yes");
        }
        System.out.format("+------------+------------+------------+%n");
    }

    // Display menu items in a clean table format
    public static void displayMenu(List<MenuItem> menuItems) {
        String leftAlignFormat = "| %-4s | %-20s | %-12s | %-10s |%n";
        System.out.format("+------+----------------------+--------------+------------+%n");
        System.out.format("| ID   | Item Name            | Category     | Price      |%n");
        System.out.format("+------+----------------------+--------------+------------+%n");
        for (MenuItem item : menuItems) {
            System.out.format(leftAlignFormat,
                item.getId(),
                item.getName(),
                item.getCategory(),
                String.format("$%.2f", item.getPrice()));
        }
        System.out.format("+------+----------------------+--------------+------------+%n");
    }

    // Display reservations in a clean table format
    public static void displayReservations(List<Reservation> reservations) {
        String leftAlignFormat = "| %-15s | %-10s | %-20s |%n";
        System.out.format("+-----------------+------------+----------------------+%n");
        System.out.format("| Name            | Table No.  | Date & Time          |%n");
        System.out.format("+-----------------+------------+----------------------+%n");
        for (Reservation res : reservations) {
            System.out.format(leftAlignFormat,
                res.getCustomerName(),
                res.getTable().getTableNumber(),
                res.getDateTime().toString());
        }
        System.out.format("+-----------------+------------+----------------------+%n");
    }

    // Display order in a clean table format
    public static void displayOrder(Order order) {
        String leftAlignFormat = "| %-20s | %-10s |%n";
        System.out.format("+----------------------+------------+%n");
        System.out.format("| Item Name            | Price      |%n");
        System.out.format("+----------------------+------------+%n");
        for (MenuItem item : order.getItems()) {
            System.out.format(leftAlignFormat,
                item.getName(),
                String.format("$%.2f", item.getPrice()));
        }
        System.out.format("+----------------------+------------+%n");
        System.out.format("| Total                | $%.2f      |%n", order.getTotal());
        System.out.format("+----------------------+------------+%n");
    }

    public static void main(String[] args) {
        RestaurantApp app = new RestaurantApp();
        app.run();
    }
}