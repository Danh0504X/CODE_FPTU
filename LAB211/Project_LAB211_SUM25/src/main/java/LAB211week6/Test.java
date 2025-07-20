package LAB211week6;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("======== LAB WEEK6 PROGRAM MENU ========");
            System.out.println("1. Fruit Shop Management");
            System.out.println("2. Exit");
            System.out.print("Please choose one option: ");
            choice = Validator.getChoice(sc, 1, 4);
            switch (choice) {
                case 1:
                    FruitShopMenu.start(sc);
                    break;
                case 2:
                    System.out.println("Exiting main program...");
                    break;
            }
        } while (choice !=  2);
        sc.close();
    }
} 