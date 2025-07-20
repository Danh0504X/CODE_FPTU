package LAB211week6;

import java.util.Scanner;

public class Validator {
    public static int getChoice(Scanner sc, int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < min || choice > max) {
                    System.out.print("Invalid input. Enter again (" + min + "-" + max + "): ");
                } else {
                    return choice;
                }
            } catch (Exception e) {
                System.out.print("Invalid number. Enter again: ");
            }
        }
    }

    public static String getString(Scanner sc, String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }

    public static int getValidatedInt(Scanner sc, String message, java.util.function.Predicate<Integer> validator, String errorMsg) {
        while (true) {
            System.out.print(message);
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                if (!validator.test(val)) {
                    System.out.println(errorMsg);
                } else {
                    return val;
                }
            } catch (Exception e) {
                System.out.println("Invalid number. Enter again.");
            }
        }
    }
} 