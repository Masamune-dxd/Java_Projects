package HotelManagement;

import java.util.Scanner;

public class HotelManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int quantity, choice;
        // Quantities available
        int quantRooms = 0, quantPasta = 0, quantBurger = 0, quantNoodles = 0, quantShake = 0, quantChicken = 0;
        // Quantities sold
        int soldRooms = 0, soldPasta = 0, soldBurger = 0, soldNoodles = 0, soldShake = 0, soldChicken = 0;
        // Total collection
        int totalRooms = 0, totalPasta = 0, totalBurger = 0, totalNoodles = 0, totalShake = 0, totalChicken = 0;

        System.out.println("\n\t Quantity of items we have: ");
        System.out.print("\n Rooms available: ");
        quantRooms = sc.nextInt();
        System.out.print("\n Quantity of Pasta: ");
        quantPasta = sc.nextInt();
        System.out.print("\n Quantity of Burger: ");
        quantBurger = sc.nextInt();
        System.out.print("\n Quantity of Noodles: ");
        quantNoodles = sc.nextInt();
        System.out.print("\n Quantity of Shake: ");
        quantShake = sc.nextInt();
        System.out.print("\n Quantity of Chicken: ");
        quantChicken = sc.nextInt();

        menu:
        while (true) {
            System.out.println("\n\t\t\t Please select from the menu options: ");
            System.out.println("\n1) Rooms");
            System.out.println("2) Pasta");
            System.out.println("3) Burger");
            System.out.println("4) Noodles");
            System.out.println("5) Shake");
            System.out.println("6) Chicken");
            System.out.println("7) Information regarding sales and collection");
            System.out.println("8) Exit");

            System.out.print("\n Please Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\n\n Enter the number of rooms you want: ");
                    quantity = sc.nextInt();
                    if (quantRooms - soldRooms >= quantity) {
                        soldRooms += quantity;
                        totalRooms += quantity * 1000;
                        System.out.println("\n\n\t\t" + quantity + " room(s) have been allotted to you!");
                    } else {
                        System.out.println("\n\t Only " + (quantRooms - soldRooms) + " Rooms remaining in hotel");
                    }
                    break;

                case 2:
                    System.out.print("\n\n Enter Pasta Quantity: ");
                    quantity = sc.nextInt();
                    if (quantPasta - soldPasta >= quantity) {
                        soldPasta += quantity;
                        totalPasta += quantity * 200;
                        System.out.println("\n\n\t\t" + quantity + " pasta(s) have been ordered for you!");
                    } else {
                        System.out.println("\n\t Only " + (quantPasta - soldPasta) + " Pasta remaining.");
                    }
                    break;

                case 3:
                    System.out.print("\n\n Enter Burger Quantity: ");
                    quantity = sc.nextInt();
                    if (quantBurger - soldBurger >= quantity) {
                        soldBurger += quantity;
                        totalBurger += quantity * 200;
                        System.out.println("\n\n\t\t" + quantity + " burger(s) have been ordered for you!");
                    } else {
                        System.out.println("\n\t Only " + (quantBurger - soldBurger) + " Burger(s) remaining.");
                    }
                    break;

                case 4:
                    System.out.print("\n\n Enter Noodles Quantity: ");
                    quantity = sc.nextInt();
                    if (quantNoodles - soldNoodles >= quantity) {
                        soldNoodles += quantity;
                        totalNoodles += quantity * 200;
                        System.out.println("\n\n\t\t" + quantity + " noodles have been ordered for you!");
                    } else {
                        System.out.println("\n\t Only " + (quantNoodles - soldNoodles) + " Noodles remaining.");
                    }
                    break;

                case 5:
                    System.out.print("\n\n Enter Shake Quantity: ");
                    quantity = sc.nextInt();
                    if (quantShake - soldShake >= quantity) {
                        soldShake += quantity;
                        totalShake += quantity * 200;
                        System.out.println("\n\n\t\t" + quantity + " shake(s) have been ordered for you!");
                    } else {
                        System.out.println("\n\t Only " + (quantShake - soldShake) + " Shake(s) remaining.");
                    }
                    break;

                case 6:
                    System.out.print("\n\n Enter Chicken Quantity: ");
                    quantity = sc.nextInt();
                    if (quantChicken - soldChicken >= quantity) {
                        soldChicken += quantity;
                        totalChicken += quantity * 200;
                        System.out.println("\n\n\t\t" + quantity + " chicken(s) have been ordered for you!");
                    } else {
                        System.out.println("\n\t Only " + (quantChicken - soldChicken) + " Chicken(s) remaining.");
                    }
                    break;

                case 7:
                    System.out.println("\n\t\t Details of sales and collection ");

                    System.out.println("\nNumber of rooms we had: " + quantRooms);
                    System.out.println("Number of rooms sold: " + soldRooms);
                    System.out.println("Remaining rooms: " + (quantRooms - soldRooms));
                    System.out.println("Total rooms collection for the day: " + totalRooms);

                    System.out.println("\nNumber of Pasta we had: " + quantPasta);
                    System.out.println("Number of Pasta sold: " + soldPasta);
                    System.out.println("Remaining Pasta: " + (quantPasta - soldPasta));
                    System.out.println("Total Pasta collection for the day: " + totalPasta);

                    System.out.println("\nNumber of Burger we had: " + quantBurger);
                    System.out.println("Number of Burger sold: " + soldBurger);
                    System.out.println("Remaining Burger: " + (quantBurger - soldBurger));
                    System.out.println("Total Burger collection for the day: " + totalBurger);

                    System.out.println("\nNumber of Noodles we had: " + quantNoodles);
                    System.out.println("Number of Noodles sold: " + soldNoodles);
                    System.out.println("Remaining Noodles: " + (quantNoodles - soldNoodles));
                    System.out.println("Total Noodles collection for the day: " + totalNoodles);

                    System.out.println("\nNumber of Shake we had: " + quantShake);
                    System.out.println("Number of Shake sold: " + soldShake);
                    System.out.println("Remaining Shake: " + (quantShake - soldShake));
                    System.out.println("Total Shake collection for the day: " + totalShake);

                    System.out.println("\nNumber of Chicken we had: " + quantChicken);
                    System.out.println("Number of Chicken sold: " + soldChicken);
                    System.out.println("Remaining Chicken: " + (quantChicken - soldChicken));
                    System.out.println("Total Chicken collection for the day: " + totalChicken);

                    System.out.println("\nTotal collection for the day: " +
                            (totalRooms + totalPasta + totalBurger + totalNoodles + totalShake + totalChicken));
                    break;

                case 8:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    break menu;

                default:
                    System.out.println("\n Please select the numbers mentioned above!");
            }
        }
    }
}

// End of file
// mazamunexd
// Masamune-dxd
