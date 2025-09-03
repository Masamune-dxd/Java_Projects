package $JavaFiles;

public class Reservation {
  int guestCount;
  int restaurantCapacity;
  boolean isRestaurantOpen;
  boolean isConfirmed;
  
  public Reservation(int count, int capacity, boolean open) {
    if (count < 1 || count > 8) {
      System.out.println("Invalid reservation!");
    }
    guestCount = count;
		restaurantCapacity = capacity;
		isRestaurantOpen = open;
  }  
  
  public void confirmReservation() {
    if (restaurantCapacity >= guestCount && isRestaurantOpen) {
      System.out.println("Reservation confirmed");
      isConfirmed = true;
    } else {
      System.out.println("Reservation denied");
			isConfirmed = false;
    }
  }
  
  public void informUser() {
    if (!isConfirmed) {
      System.out.println("Unable to confirm reservation, please contact restaurant.");
    } else {
      System.out.println("Please enjoy your meal!");
    }
  }
  
  public static void main(String[] args) {
    // Create instances here
     // Example 1: A valid reservation attempt
        System.out.println("--- Attempting Reservation 1 ---");
        Reservation res1 = new Reservation(4, 10, true);
        res1.confirmReservation();
        res1.informUser();

        System.out.println("\n--- Attempting Reservation 2 ---");
        // Example 2: Reservation for too many guests
        Reservation res2 = new Reservation(10, 15, true); // Prints "Invalid reservation!" from constructor
        res2.confirmReservation(); // Will be denied due to guestCount > 8 and capacity check
        res2.informUser();

        System.out.println("\n--- Attempting Reservation 3 ---");
        // Example 3: Reservation for too few guests
        Reservation res3 = new Reservation(0, 5, true); // Prints "Invalid reservation!" from constructor
        res3.confirmReservation(); // Will be denied due to guestCount < 1 and capacity check
        res3.informUser();

        System.out.println("\n--- Attempting Reservation 4 ---");
        // Example 4: Restaurant is closed
        Reservation res4 = new Reservation(2, 5, false);
        res4.confirmReservation(); // Will be denied because isRestaurantOpen is false
        res4.informUser();

        System.out.println("\n--- Attempting Reservation 5 ---");
        // Example 5: Capacity exceeded
        Reservation res5 = new Reservation(7, 5, true);
        res5.confirmReservation(); // Will be denied because guestCount > restaurantCapacity
        res5.informUser();
  }
}