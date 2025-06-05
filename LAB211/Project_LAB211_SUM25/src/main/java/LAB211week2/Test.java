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
public class Test {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("======== LAB WEEK2 PROGRAM MENU ========");
            System.out.println("1. Short 51 - Calculator + BMI");
            System.out.println("2. Short 61 - Shape Calculator");
            System.out.println("3. Short 74  - Matrix");
            System.out.println("4. Exit");
            System.out.print("Please choose one option: ");
            choice = Validator.getChoice(sc, 1, 4);

            switch (choice) {
                case 1:
                    new MenuMayTinh(sc).start();  
                    break;
                case 2:
                    new ShapeProgram().start(); 
                case 3:
                    new MatrixProgram(sc).start(); 
                    break;
                case 4:
                    System.out.println("Exiting main program...");
                    break;
            }
        } while (choice != 4);
        
        sc.close();
    }
}
