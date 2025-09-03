package SupermarketBilling;

import java.io.*;
import java.util.*;

class Product {
    int pCode;
    String productName;
    float price;
    float discount;

    public Product(int pCode, String productName, float price, float discount) {
        this.pCode = pCode;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format("%-10d%-25s%-10.2f%-10.2f", pCode, productName, price, discount);
    }
}

public class SupermarketBilling {
    private static final String databaseFile = "database.txt";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SupermarketBilling supermarket = new SupermarketBilling();
        supermarket.menu();
    }

    // Load all products from file
    private List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(databaseFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 4) {
                    int pCode = Integer.parseInt(parts[0]);
                    String productName = parts[1];
                    float price = Float.parseFloat(parts[2]);
                    float discount = Float.parseFloat(parts[3]);
                    products.add(new Product(pCode, productName, price, discount));
                }
            }
        } catch (FileNotFoundException e) {
            // file will be created when saving
        } catch (IOException e) {
            System.out.println("Error reading database file.");
        }
        return products;
    }

    // Save all products to file
    private void saveProducts(List<Product> products) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(databaseFile))) {
            for (Product p : products) {
                pw.printf("%d %s %.2f %.2f%n", p.pCode, p.productName, p.price, p.discount);
            }
        } catch (IOException e) {
            System.out.println("Error writing to database file.");
        }
    }

    private boolean productCodeExists(int code, List<Product> products) {
        for (Product p : products) if (p.pCode == code) return true;
        return false;
    }

    public void menu() {
        while (true) {
            System.out.println("\n\t\t\t\t Supermarket Main Menu");
            System.out.println("\t\t\t\t ____________________________");
            System.out.println("\t\t\t\t  1) Admin");
            System.out.println("\t\t\t\t  2) Buyer");
            System.out.println("\t\t\t\t  3) Exit");
            System.out.print("\n\t\t\t  Please select! ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\t\t\t Email: ");
                    String email = sc.next();
                    System.out.print("\t\t\t Password: ");
                    String password = sc.next();
                    if (email.equals("test@gmail.com") && password.equals("test123")) {
                        admin();
                    } else {
                        System.out.println("\t\t\t Invalid email/password");
                    }
                    break;
                case 2:
                    buyer();
                    break;
                case 3:
                    System.out.println("\n\t\t\t Thank you for visiting!");
                    System.exit(0);
                default:
                    System.out.println("\t\t\t Please select from the given options");
            }
        }
    }

    public void admin() {
        while (true) {
            System.out.println("\n\n\t\t\t Admin Menu");
            System.out.println("\t\t\t|____1) Add Product____|");
            System.out.println("\t\t\t|____2) Edit Product____|");
            System.out.println("\t\t\t|____3) Remove Product____|");
            System.out.println("\t\t\t|____4) List Products____|");
            System.out.println("\t\t\t|____5) Back to Main Menu____|");
            System.out.print("\n\t Please enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addProduct(); break;
                case 2: editProduct(); break;
                case 3: removeProduct(); break;
                case 4: listProducts(); break;
                case 5: return;
                default: System.out.println("\t\t\t Invalid choice");
            }
        }
    }

    public void buyer() {
        while (true) {
            System.out.println("\t\t\t  Buyer");
            System.out.println("\t\t\t________________");
            System.out.println("\t\t\t 1) Buy product");
            System.out.println("\t\t\t 2) Go back");
            System.out.print(" \t\t\t Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: generateReceipt(); break;
                case 2: return;
                default: System.out.println("\t\t\t Invalid choice");
            }
        }
    }

    public void addProduct() {
        List<Product> products = loadProducts();
        System.out.print("\n\n\t\t\t Add New Product\n\n\t Product Code: ");
        int pCode = sc.nextInt();
        if (productCodeExists(pCode, products)) {
            System.out.println("\t\t\t Error: Product code already exists!");
            return;
        }
        System.out.print("\n\n\t Name of the Product: ");
        String productName = sc.next();
        System.out.print("\n\n\t Price of the Product: ");
        float price = sc.nextFloat();
        System.out.print("\n\n\t Discount on the Product (%): ");
        float discount = sc.nextFloat();

        products.add(new Product(pCode, productName, price, discount));
        saveProducts(products);
        System.out.println("\n\n\t\t Record inserted successfully!");
    }

    public void editProduct() {
        List<Product> products = loadProducts();
        System.out.print("\n\n\t\t\t Modify Product Record\n\t\t\t Enter Product Code to Modify: ");
        int codeToEdit = sc.nextInt();

        boolean found = false;
        for (Product p : products) {
            if (p.pCode == codeToEdit) {
                System.out.print("\n\t\t Product New Code (" + p.pCode + "): ");
                int newCode = sc.nextInt();
                if (newCode != p.pCode && productCodeExists(newCode, products)) {
                    System.out.println("\t\t\t Error: New product code already exists!");
                    return;
                }
                p.pCode = newCode;
                System.out.print("\n\t\t Name of the Product (" + p.productName + "): ");
                p.productName = sc.next();
                System.out.print("\n\t\t Price (" + p.price + "): ");
                p.price = sc.nextFloat();
                System.out.print("\n\t\t Discount (%) (" + p.discount + "): ");
                p.discount = sc.nextFloat();
                found = true;
                break;
            }
        }
        if (found) {
            saveProducts(products);
            System.out.println("\n\n\t\t Record updated successfully!");
        } else {
            System.out.println("\n\n\t\t Product not found!");
        }
    }

    public void removeProduct() {
        List<Product> products = loadProducts();
        System.out.print("\n\n\t\t\t Remove Product Record\n\t\t\t Enter Product Code to Remove: ");
        int codeToRemove = sc.nextInt();

        boolean found = false;
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            Product p = it.next();
            if (p.pCode == codeToRemove) {
                it.remove();
                found = true;
                break;
            }
        }
        if (found) {
            saveProducts(products);
            System.out.println("\n\n\t\t Product removed successfully!");
        } else {
            System.out.println("\n\n\t\t Product not found!");
        }
    }

    public void listProducts() {
        List<Product> products = loadProducts();
        System.out.println("\n\n\t\t\t List of All Products");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-10s%-25s%-10s%-10s%n", "Code", "Name", "Price", "Discount");
        System.out.println("-----------------------------------------------------------");

        if (products.isEmpty()) {
            System.out.println("\t\t\t No products available.");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
        }
        System.out.println("-----------------------------------------------------------");
    }

    public void generateReceipt() {
        List<Product> products = loadProducts();
        List<Product> cart = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        float totalAmount = 0;
        sc.nextLine(); // Clear newline

        while (true) {
            System.out.print("\n\t\t Enter Product Code to Buy: ");
            int productCode = sc.nextInt();
            Product found = null;
            for (Product p : products) {
                if (p.pCode == productCode) {
                    found = p;
                    break;
                }
            }
            if (found != null) {
                System.out.print("\n\t\t Enter Quantity: ");
                int quantity = sc.nextInt();
                if (quantity > 0) {
                    cart.add(found);
                    quantities.add(quantity);
                    float priceWithDiscount = found.price * quantity * (1 - found.discount / 100.0f);
                    totalAmount += priceWithDiscount;
                } else {
                    System.out.println("\t\t\t Invalid quantity.");
                }
            } else {
                System.out.println("\t\t\t Product not found!");
            }
            System.out.print("\n\t\t Do you want to add more items? (y/n): ");
            char addMore = sc.next().toLowerCase().charAt(0);
            if (addMore != 'y') break;
        }

        System.out.println("\n\n\t\t\t\t ______RECEIPT______");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-10s%-25s%-10s%-15s%n", "Code", "Name", "Quantity", "Amount");
        System.out.println("-----------------------------------------------------------");
        for (int i = 0; i < cart.size(); i++) {
            Product item = cart.get(i);
            int quantity = quantities.get(i);
            float amount = item.price * quantity * (1 - item.discount / 100.0f);
            System.out.printf("%-10d%-25s%-10d%-15.2f%n", item.pCode, item.productName, quantity, amount);
        }
        System.out.println("-----------------------------------------------------------");
        System.out.printf("\t\t\t\t Total Amount: $%.2f%n", totalAmount);
        System.out.println("-----------------------------------------------------------");
        System.out.println("\t\t\t Thank you for your purchase!");
    }
}