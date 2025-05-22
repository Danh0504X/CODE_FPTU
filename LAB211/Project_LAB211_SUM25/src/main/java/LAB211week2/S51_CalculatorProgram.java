/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week2;

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;

public class S51_CalculatorProgram {
    private final Scanner sc = new Scanner(System.in);
    private final S51_Calculator calculator = new S51_Calculator();
    private final S51_BMICalculator bmiCalculator = new S51_BMICalculator();
    private final S51_Validator validator = new S51_Validator();

    public void run() {
        while (true) {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            System.out.print("Please choose one option: ");

            int choice = validator.getMenuChoice(sc);
            switch (choice) {
                case 1 -> calculator.run(sc, validator);
                case 2 -> bmiCalculator.run(sc, validator);
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
            }
        }
    }
}

