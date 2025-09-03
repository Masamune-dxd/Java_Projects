package RestaurantManagement;

import java.time.LocalDateTime;

public class Reservation {
    private String customerName;
    private int guests;
    private LocalDateTime dateTime;
    private Table table;

    public Reservation(String customerName, int guests, LocalDateTime dateTime, Table table) {
        this.customerName = customerName;
        this.guests = guests;
        this.dateTime = dateTime;
        this.table = table;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getGuests() {
        return guests;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Table getTable() {
        return table;
    }
}