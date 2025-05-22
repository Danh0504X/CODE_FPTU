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
public class Matrix {
    private int rows;
    private int cols;
    private double[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];
    }

    public void input(Scanner sc, String name) {
        System.out.println("Enter " + name + " matrix " + rows + "x" + cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                data[i][j] = Validator.getValidDouble(sc, name + "[" + i + "][" + j + "]: ");
    }

    public void print(String name) {
        System.out.println(name + ":");
        for (double[] row : data) {
            for (double val : row) {
                System.out.printf("%.2f ", val);
            }
            System.out.println();
        }
    }

    public Matrix add(Matrix m2) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.data[i][j] = this.data[i][j] + m2.data[i][j];
        return result;
    }

    public Matrix subtract(Matrix m2) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.data[i][j] = this.data[i][j] - m2.data[i][j];
        return result;
    }

    public Matrix multiply(Matrix m2) {
        Matrix result = new Matrix(rows, m2.cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < m2.cols; j++)
                for (int k = 0; k < cols; k++)
                    result.data[i][j] += this.data[i][k] * m2.data[k][j];
        return result;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
