package RestaurantManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TableManager {
    private List<Table> tables;

    public TableManager() {
        tables = new ArrayList<>();
        // Sample tables
        tables.add(new Table(1, 2));
        tables.add(new Table(2, 4));
        tables.add(new Table(3, 6));
    }

    public List<Table> getTables() {
        return tables;
    }

    public Optional<Table> findAvailableTable(int guests) {
        return tables.stream()
            .filter(table -> table.isAvailable() && table.getCapacity() >= guests)
            .findFirst();
    }
}