/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de190155.project_lab211_sum25;

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;

public class ShapeProgram {
    private Scanner sc = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            System.out.println("====== SHAPE CALCULATOR ======");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Back to main menu");
            System.out.println("Select shape:");
            choice = Validator.getChoice(sc, 1, 4);

            switch (choice) {
                case 1:
                    double r = Validator.getPositiveDouble(sc, "Enter radius: ");
                    new Circle(r).printResult();
                    break;
                case 2:
                    double w = Validator.getPositiveDouble(sc, "Enter width: ");
                    double l = Validator.getPositiveDouble(sc, "Enter length: ");
                    new Rectangle(w, l).printResult();
                    break;
                case 3:
                    double a = Validator.getPositiveDouble(sc, "Enter side A: ");
                    double b = Validator.getPositiveDouble(sc, "Enter side B: ");
                    double c = Validator.getPositiveDouble(sc, "Enter side C: ");
                    if (a + b > c && a + c > b && b + c > a) {
                        new Triangle(a, b, c).printResult();
                    } else {
                        System.out.println("Invalid triangle sides.");
                    }
                    break;
            }

        } while (choice != 4);
    }
}
