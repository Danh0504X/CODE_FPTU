/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week4;

import LAB211week3.*;
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
            System.out.println("2. [Tên bài tập thứ hai]");
            System.out.println("3. Exit");
            System.out.print("Please choose one option: ");
            choice = Validator.getChoice(sc, 1, 5);

            switch (choice) {
                case 1:
                   Case1.run(sc);
                    break;
                case 2:
                   QuickSort.execute(sc);
                   break;
                case 3:
                    BinarySearch.execute(sc);
                    break;
                case 4:
                    StackDemo.execute(sc);
                    break;
                case 5:
                    System.out.println("Exiting main program...");
                    break;
            }
        } while (choice != 5);
        
        sc.close();
    }
}
