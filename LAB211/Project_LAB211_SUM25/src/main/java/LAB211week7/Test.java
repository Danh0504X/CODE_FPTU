package LAB211week7;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("======== LAB WEEK7 PROGRAM MENU ========");
            System.out.println("1. East Asia Country Management");
            System.out.println("2. Shape OOP Demo");
            System.out.println("3. Exit");
            System.out.print("Please choose one option: ");
            choice = Validator.getChoice(sc, 1, 3);
            switch (choice) {
                case 1:
                    EastAsiaMenu.start(sc);
                    break;
                case 2:
                    ShapeMenu.start(sc);
                    break;
                case 3:
                    System.out.println("Exiting main program...");
                    break;
            }
        } while (choice != 3);
        sc.close();
    }
} 