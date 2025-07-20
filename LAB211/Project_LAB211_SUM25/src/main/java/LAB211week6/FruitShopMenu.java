package LAB211week6;

import java.util.Scanner;

public class FruitShopMenu {
    public static void start(Scanner sc) {
        FruitShopManager manager = new FruitShopManager(sc);
        while (true) {
            System.out.println("\n===== FRUIT SHOP MENU =====");
            System.out.println("1. Add Fruit");
            System.out.println("2. View Fruit List");
            System.out.println("3. Create Order");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    manager.createFruit();
                    break;
                case "2":
                    manager.showFruits();
                    break;
                case "3":
                    manager.shopping();
                    break;
                case "4":
                    manager.viewOrders();
                    break;
                case "5":
                    System.out.println("Exiting Fruit Shop. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start(sc);  
    }
}
