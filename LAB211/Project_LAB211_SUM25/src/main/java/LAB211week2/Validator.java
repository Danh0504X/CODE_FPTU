/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week2;

import LAB211week2.S51_Operator;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
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
    
    public static double getPositiveDouble(Scanner sc, String message) {
        double val;
        do {
            val = getValidDouble(sc, message);
            if (val <= 0) {
                System.out.println("Value must be greater than 0.");
            }
        } while (val <= 0);
        return val;
    }

    public static double getValidDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    
    public static String getValidOperator(Scanner sc, String message) {
    while (true) {
        System.out.print(message);
        String input = sc.nextLine().trim();

        if (input.equals("+") || input.equals("-") || input.equals("*") ||
            input.equals("/") || input.equals("^") || input.equals("=")) {
            return input; 
        }

        System.out.println("Please input (+, -, *, /, ^, =)");
        }
    }
    
    public static int getValidInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
