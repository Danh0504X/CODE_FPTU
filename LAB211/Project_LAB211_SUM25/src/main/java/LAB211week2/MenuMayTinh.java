/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week2;

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;

public class MenuMayTinh {
    private Scanner sc;

    public MenuMayTinh(Scanner sc) {
        this.sc = sc;
    }

    public void start() {
        int choice;

        do {
            System.out.println("======== Calculator Program ========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            System.out.print("Please choose one option: ");

            choice = Validator.getChoice(this.sc,1,3);

            switch (choice) {
                case 1:
                    runNormalCalculator();
                    break;
                case 2:
                    runBMICalculator();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);

    }

    private void runNormalCalculator() {
        mayTinh mtinh = new mayTinh();
        System.out.println("----- Normal Calculator -----");
        System.out.println("Allowed operations: +  -  *  /  ^  =");

 //
 
                double so1 = Validator.getValidDouble(sc, "Nhap so thu nhat");
                mtinh.setMemory(so1);
                
                while(true) {
                    String op = Validator.getValidOperator(sc, "Hay nhap phep tinh");
                    
                    if(op.equals("=")) {
                        System.out.println("Resuilt: " + mtinh.getMemory());
                        return;
                        }
                    
                    double so2 = Validator.getValidDouble(sc,"Nhap so thu 2: ");
                        
                  mtinh.changeMemory(op, so2);
                System.out.println("Memory = " + mtinh.getMemory());    
            }
         }
    
    private void runBMICalculator() {
        System.out.println("----- BMI Calculator -----");

        double weight = Validator.getPositiveDouble(sc, "Enter Weight (kg): ");
        double height = Validator.getPositiveDouble(sc, "Enter Height (cm): ");

        double heightMeters = height / 100.0;
        TinhBMI bmi = new TinhBMI(weight, heightMeters);

        try {
            double bmiValue = bmi.calculateBMI();
            System.out.println("BMI Number: " + String.format("%.2f", bmiValue));
            System.out.println("BMI Status: " + bmi.getBMIStatus());
            }   catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
        }

}