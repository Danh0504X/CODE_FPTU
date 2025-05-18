/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week1;

import java.util.Scanner;

public class S11_ConverterProgram {
    private final Scanner sc = new Scanner(System.in);
    private final S11_Converter converter = new S11_Converter();
    private final S11_Validator validator = new S11_Validator();

    public void run() {
        while (true) {
            System.out.println("========== BASE CONVERSION PROGRAM ==========");
            System.out.println("1. Binary");
            System.out.println("2. Decimal");
            System.out.println("3. Hexadecimal");
            System.out.println("0. Exit");
            System.out.print("Enter input base (1-3) or 0 to exit: ");
            int inputChoice = validator.getChoice(sc, 0, 3);
            if (inputChoice == 0) {
                System.out.println("Program exited.");
                break;
            }

            System.out.print("Enter output base (1-3): ");
            int outputChoice = validator.getChoice(sc, 1, 3);

            System.out.print("Enter the input value: ");
            String inputValue = validator.getValidatedValue(sc, inputChoice);

            int realInputBase = mapBase(inputChoice);
            int realOutputBase = mapBase(outputChoice);

            String result = converter.convert(inputValue, realInputBase, realOutputBase);
            System.out.println("==> Result: " + result + "\n");
        }
    }

    private int mapBase(int choice) {
        return (choice == 1) ? 2 : (choice == 2) ? 10 : 16;
    }
}
