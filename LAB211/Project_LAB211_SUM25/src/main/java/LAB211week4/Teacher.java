/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week4;

import java.util.Scanner;

public class Teacher extends Person {
    private int yearInProfession;
    private String contractType;
    private double salaryCoefficient;

    public Teacher() {
        super();
        this.yearInProfession = 0;
        this.contractType = "";
        this.salaryCoefficient = 0.0;
    }

    public void inputAll(Scanner sc) {
        inputCommon(sc);
        int age = Validator.getCurrentYear() - yearOfBirth;
        yearInProfession = Validator.getIntInRange(sc, "Year in the profession: ", 0, age - 1);
        contractType = Validator.getContractType(sc, "Contract type (Long/Short): ");
        salaryCoefficient = Validator.getDoubleFrom(sc, "Salary coefficient: ", 0.0);
    }

    public void display() {
        displayCommon();
        System.out.printf(" - %-5d - %-5s - %.1f\n", yearInProfession, contractType, salaryCoefficient);
    }

    public int getYearInProfession() {
        return yearInProfession;
    }
}
