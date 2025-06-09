/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author ADMIN
 */
import java.util.Queue;
import java.util.Scanner;
import model.Patient;

public class PatientView {
    private Scanner sc = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Dang ky benh nhan");
        System.out.println("2. Xu ly benh nhan");
        System.out.println("3. Xem danh sach cho");
        System.out.println("0. Thoat");
        System.out.print("Lua chon cua ban: ");
        return sc.nextInt();
    }
    
    public String prompt(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }
    
    public Patient inputPatientInfo() {
    String name;
    int age;
    
    String nameRegex = "^[A-Za-z ]+$";

    while (true) {
        sc.nextLine(); 
        System.out.print("Nhap ten benh nhan (khong dau): ");
        name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Ten khong duoc de trong.");
        } else if (!name.matches(nameRegex)) {
            System.out.println("Ten chi duoc chua chu cai (khong dau) va dau cach. Khong duoc chua so, ky tu dac biet hoac dau tieng Viet.");
        } else {
            break;
        }
    }

    while (true) {
        System.out.print("Nhap tuoi (1–100): ");
        if (sc.hasNextInt()) {
            age = sc.nextInt();
            if (age >= 1 && age <= 100) {
                break;
            } else {
                System.out.println("Tuoi phai tu 1 den 100.");
            }
        } else {
            System.out.println("Vui long nhap so nguyen.");
            sc.next(); 
        }
    }

    return new Patient(name, age);
    }

    
    public void showMessage(String msg) {
        System.out.println(msg);
    }
    
    public void showPatient(Patient p) {
        if (p != null) {
            System.out.println(">> Dang khap cho: " + p);
        } else {
            System.out.println(">> Khong co benh nhan nao trong hang doi.");
        }
    }

    public void showQueue(Queue<Patient> queue) {
        if (queue.isEmpty()) {
            System.out.println(">> hang doi trong.");
        } else {
            System.out.println(">> Danh sach benh nhan dang cho:");
            for (Patient p : queue) {
                System.out.println(" - " + p);
            }
        }
    }
}
