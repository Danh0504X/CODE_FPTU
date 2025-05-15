/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.student;

import java.util.Scanner;

public class studentView {
    private final Scanner sc = new Scanner(System.in);

    public String prompt(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }
    
    public void showMainMenu() {
        System.out.println("\n=============== STUDENT MANAGEMENT ===============");
        System.out.println("1. Display the list of students.");
        System.out.println("2. Find and display the student with the highest GPA");
        System.out.println("3. Search for a student by Student ID");
        System.out.println("4. Sort and display the student list in descending order of GPA");
        System.out.println("0. Exit");
    }

    public void showStudent(student student) {
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println(student);
        }
    }

    public void showAllStudents(student[] students) {
        if (students.length == 0) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("-------- STUDENT LIST --------");
        for (student s : students) {
            System.out.println(s);
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showError(String error) {
        System.out.println(error);
    }
}
