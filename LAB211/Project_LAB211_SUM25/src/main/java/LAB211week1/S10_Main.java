/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week1;

import static LAB211week1.S10_LinearSearchApp.getPositiveInt;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class S10_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = getPositiveInt(scanner, "Enter number of array: ");
        int searchValue = getPositiveInt(scanner, "Enter search value: ");

        S10_LinearSearchApp app = new S10_LinearSearchApp(size, searchValue);
        app.run();
        }
}
