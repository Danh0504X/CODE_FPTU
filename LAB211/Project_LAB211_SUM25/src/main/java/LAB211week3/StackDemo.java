/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week3;

import java.util.Scanner;

public class StackDemo {
    public static void execute(Scanner sc) {
        MyStack stack = new MyStack();
        int choice;

        do {
            System.out.println("===== STACK DEMO =====");
            System.out.println("1. Push value");
            System.out.println("2. Pop value");
            System.out.println("3. Get top value");
            System.out.println("4. Display stack");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice = Validator.getChoice(sc, 1, 5);

            switch (choice) {
                case 1:
                    int val = Validator.getValidInt(sc, "Enter value to push: ");
                    stack.push(val);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.get();
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting stack demo...");
            }
        } while (choice != 5);
    }
}
