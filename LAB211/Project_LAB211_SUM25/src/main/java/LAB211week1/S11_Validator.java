/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week1;

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;

public class S11_Validator {

    public int getChoice(Scanner sc, int min, int max) {
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

    public String getValidatedValue(Scanner sc, int baseChoice) {
        while (true) {
            String value = sc.nextLine().trim().toUpperCase();
            if (isValid(value, baseChoice)) return value;
            System.out.print("Invalid format. Please enter again: ");
        }
    }

    private boolean isValid(String value, int baseChoice) {
        switch (baseChoice) {
            case 1: return value.matches("[01]+");
            case 2: return value.matches("\\d+");
            case 3: return value.matches("[0-9A-F]+");
            default: return false;
        }
    }
}
