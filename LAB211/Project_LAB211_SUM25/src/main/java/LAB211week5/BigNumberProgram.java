/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week5;

import java.util.Scanner;

public class BigNumberProgram {
    public static void start(Scanner sc) {
        System.out.println("------ LARGE NUMBER OPERATION ------");
        String num1 = Validator.getString(sc, "Enter first large number: ");
        String num2 = Validator.getString(sc, "Enter second large number: ");
        BigNumber a = new BigNumber(num1);
        BigNumber b = new BigNumber(num2);
        BigNumber sum = a.add(b);
        BigNumber product = a.multiply(b);
        System.out.println("Result of Addition: " + sum);
        System.out.println("Result of Multiplication: " + product);
    }
}