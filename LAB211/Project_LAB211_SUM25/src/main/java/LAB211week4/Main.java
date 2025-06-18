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
public class Main {
    
     public static void studentMenu(Scanner sc) {
        StudentManagement sm = new StudentManagement();

        while (true) {
            System.out.println("======== STUDENT MANAGEMENT ========");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = Validator.getChoice(sc, 1, 5);

            switch (choice) {
                case 1:
                    sm.createStudent();
                    break;
                case 2:
                    sm.findAndSortStudent();
                    break;
                case 3:
                    sm.updateOrDeleteStudent();
                    break;
                case 4:
                    sm.reportStudentCourse();
                    break;
                case 5:
                    return;
            }
        }
    }
}
