/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week5;
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
            System.out.println("1. Short P84 - Large Number");
            System.out.println("2. Long P021 - Student Managerment");
            System.out.println("3. Short P109 - Course Management");
            System.out.println("4. Exit");
            System.out.print("Please choose one option: ");
            choice = Validator.getChoice(sc, 1, 4);

            switch (choice) {
                case 1:
                  BigNumberProgram.start(sc);
                    break;
                case 2:
                   ReservationProgram.start(sc);
                    break;
                case 3:
                   CourseProgram.start(sc);
                    break;
                case 4:
                    System.out.println("Exiting main program...");
                    break;
            }
        } while (choice != 4);
        
        sc.close();
    }
}
