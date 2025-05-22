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
public class S51_Calculator {

    public void run(Scanner sc, S51_Validator validator) {
        System.out.println("----- Normal Calculator -----");

        double memory = validator.getValidDouble(sc, "Enter number: ");
        while (true) {
            S51_Operator operator = validator.getValidOperator(sc, "Enter Operator: ");
            if (operator == S51_Operator.EQUAL) {
                System.out.println("Result: " + memory);
                break;
            }
            double number = validator.getValidDouble(sc, "Enter number: ");
            try {
                memory = calculate(memory, operator, number);
                System.out.println("Memory: " + memory);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public double calculate(double a, S51_Operator operator, double b) {
        return switch (operator) {
            case PLUS -> a + b;
            case MINUS -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> {
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                yield a / b;
            }
            case POWER -> Math.pow(a, b);
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }
}

