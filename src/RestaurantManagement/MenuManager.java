package RestaurantManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenuManager {
    private List<MenuItem> menuItems;

    public MenuManager() {
        menuItems = new ArrayList<>();
        // Sample menu items
        menuItems.add(new MenuItem(1, "Margherita Pizza", "Main", 8.99));
        menuItems.add(new MenuItem(2, "Caesar Salad", "Starter", 5.49));
        menuItems.add(new MenuItem(3, "Chocolate Cake", "Dessert", 4.99));
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public Optional<MenuItem> getMenuItemById(int id) {
        return menuItems.stream().filter(item -> item.getId() == id).findFirst();
    }
}