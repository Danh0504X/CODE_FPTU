package LAB211week6;

import java.util.*;

public class FruitShopManager {
    private ArrayList<Fruit> fruits = new ArrayList<>();
    private Hashtable<String, ArrayList<OrderItem>> orders = new Hashtable<>();
    private Scanner sc;

    public FruitShopManager(Scanner sc) {
        this.sc = sc;
    }

    public void createFruit() {
        do {
            System.out.println("--- Create Fruit ---");
            String id = Validator.getString(sc, "Fruit Id: ");
            String name = Validator.getString(sc, "Fruit Name: ");
            double price = Validator.getValidatedInt(sc, "Price: ", v -> v > 0, "Price must be > 0");
            int quantity = Validator.getValidatedInt(sc, "Quantity: ", v -> v > 0, "Quantity must be > 0");
            String origin = Validator.getString(sc, "Origin: ");
            fruits.add(new Fruit(id, name, price, quantity, origin));
            System.out.print("Do you want to continue (Y/N)? ");
        } while (sc.nextLine().trim().equalsIgnoreCase("Y"));
        showFruits();
    }

    public void showFruits() {
        System.out.println("List of Fruit:");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        int idx = 1;
        for (Fruit f : fruits) {
            System.out.printf("%2d %-15s %-12s %.0f$\n", idx++, f.getName(), f.getOrigin(), f.getPrice());
        }
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }
        for (String customer : orders.keySet()) {
            System.out.println("Customer: " + customer);
            System.out.println("Product | Quantity | Price | Amount");
            ArrayList<OrderItem> items = orders.get(customer);
            double total = 0;
            int idx = 1;
            for (OrderItem item : items) {
                double amount = item.getAmount();
                System.out.printf("%d. %-10s %3d %5.0f$ %5.0f$\n", idx++, item.getFruitName(), item.getQuantity(), item.getPrice(), amount);
                total += amount;
            }
            System.out.println("Total: " + (int)total + "$\n");
        }
    }

    public void shopping() {
        if (fruits.isEmpty()) {
            System.out.println("No fruits available.");
            return;
        }
        ArrayList<OrderItem> cart = new ArrayList<>();
        while (true) {
            showFruits();
            int item = Validator.getValidatedInt(sc, "Select Item: ", v -> v > 0 && v <= fruits.size(), "Invalid item.");
            Fruit f = fruits.get(item - 1);
            System.out.println("You selected: " + f.getName());
            int qty = Validator.getValidatedInt(sc, "Please input quantity: ", v -> v > 0 && v <= f.getQuantity(), "Invalid quantity.");
            cart.add(new OrderItem(f.getName(), qty, f.getPrice()));
            System.out.print("Do you want to order now (Y/N): ");
            String orderNow = sc.nextLine().trim();
            if (orderNow.equalsIgnoreCase("Y")) {
                System.out.println("Product | Quantity | Price | Amount");
                double total = 0;
                for (OrderItem itemO : cart) {
                    double amount = itemO.getAmount();
                    System.out.printf("%-10s %3d %5.0f$ %5.0f$\n", itemO.getFruitName(), itemO.getQuantity(), itemO.getPrice(), amount);
                    total += amount;
                }
                System.out.println("Total: " + (int)total + "$\n");
                System.out.print("Input your name: ");
                String name = sc.nextLine().trim();
                orders.put(name, new ArrayList<>(cart));
                System.out.println("Order saved. Returning to main menu.");
                return;
            }
        }
    }
} 