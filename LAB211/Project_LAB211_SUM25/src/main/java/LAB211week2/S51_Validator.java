/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week2;

import java.util.Scanner;
/**
 *
 * @author ADMIN
 */


public class S51_Validator {

    public int getMenuChoice(Scanner sc) {
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 3) return choice;
                System.out.println("Please enter 1-3.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    public double getValidDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public S51_Operator getValidOperator(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
            S51_Operator op = S51_Operator.fromString(input);
            if (op != null) return op;
            System.out.println("Please input (+, -, *, /, ^, =)");
        }
    }
}
