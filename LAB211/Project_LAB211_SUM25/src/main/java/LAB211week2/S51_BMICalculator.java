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
public class S51_BMICalculator {

    public void run(Scanner sc, S51_Validator validator) {
        System.out.println("----- BMI Calculator -----");
        double weight = validator.getValidDouble(sc, "Enter Weight (kg): ");
        double heightCm = validator.getValidDouble(sc, "Enter Height (cm): ");
        double heightM = heightCm / 100;

        double bmi = weight / (heightM * heightM);
        S51_BMIStatus status = getStatus(bmi);

        System.out.printf("BMI Number: %.2f\n", bmi);
        System.out.println("BMI Status: " + status);
    }

    public S51_BMIStatus getStatus(double bmi) {
        if (bmi < 19) return S51_BMIStatus.UNDER_STANDARD;
        if (bmi < 25) return S51_BMIStatus.STANDARD;
        if (bmi < 30) return S51_BMIStatus.OVERWEIGHT;
        if (bmi < 40) return S51_BMIStatus.FAT;
        return S51_BMIStatus.VERY_FAT;
    }
}
