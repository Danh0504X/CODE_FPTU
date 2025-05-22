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

public class MatrixProgram {
    private Scanner sc;

    public MatrixProgram(Scanner sc) {
        this.sc = sc;
    }

    public void start() {
        int choice;
        do {
            System.out.println("======= Matrix Calculator =======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Back to main menu");
            System.out.println("Choose an option: ");
            choice = Validator.getChoice(sc, 1, 4);

            switch (choice) {
                case 1: handleAddition(); break;
                case 2: handleSubtraction(); break;
                case 3: handleMultiplication(); break;
                case 4: System.out.println("Returning to main menu..."); break;
            }
        } while (choice != 4);
    }

    private void handleAddition() {
        System.out.println("--- Addition Matrix ---");
        int row = Validator.getValidInt(sc, "Enter Row: ");
        int col = Validator.getValidInt(sc, "Enter Column: ");
        Matrix m1 = new Matrix(row, col);
        Matrix m2 = new Matrix(row, col);
        m1.input(sc, "Matrix1");
        m2.input(sc, "Matrix2");
        Matrix result = m1.add(m2);
        result.print("Result");
    }

    private void handleSubtraction() {
        System.out.println("--- Subtraction Matrix ---");
        int row = Validator.getValidInt(sc, "Enter Row: ");
        int col = Validator.getValidInt(sc, "Enter Column: ");
        Matrix m1 = new Matrix(row, col);
        Matrix m2 = new Matrix(row, col);
        m1.input(sc, "Matrix1");
        m2.input(sc, "Matrix2");
        Matrix result = m1.subtract(m2);
        result.print("Result");
    }

    private void handleMultiplication() {
        System.out.println("--- Multiplication Matrix ---");
        int row1 = Validator.getValidInt(sc, "Enter Row Matrix 1: ");
        int col1 = Validator.getValidInt(sc, "Enter Column Matrix 1: ");
        int row2 = Validator.getValidInt(sc, "Enter Row Matrix 2: ");
        int col2 = Validator.getValidInt(sc, "Enter Column Matrix 2: ");

        if (col1 != row2) {
            System.out.println("Cannot multiply: Column of Matrix1 must equal Row of Matrix2");
            return;
        }

        Matrix m1 = new Matrix(row1, col1);
        Matrix m2 = new Matrix(row2, col2);
        m1.input(sc, "Matrix1");
        m2.input(sc, "Matrix2");
        Matrix result = m1.multiply(m2);
        result.print("Result");
    }
}
