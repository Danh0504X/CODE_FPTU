/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week4;
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
            System.out.println("======== LAB WEEK4 PROGRAM MENU ========");
            System.out.println("1. Short P105 - Input & Display Student and Teacher Info");
            System.out.println("2. Long P021 - Student Managerment");
            System.out.println("3. Exit");
            System.out.print("Please choose one option: ");
            choice = Validator.getChoice(sc, 1, 3);

            switch (choice) {
                case 1:
                    Main2.assignment105Menu(sc);
                    break;
                case 2:
                    Main.studentMenu(sc);
                   break;
                case 3:
                    System.out.println("Exiting main program...");
                    break;
            }
        } while (choice != 3);
        
        sc.close();
    }
}
