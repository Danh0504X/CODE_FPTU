/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week4;

import java.util.Scanner;

public class Student2 extends Person {
    private int yearOfAdmission;
    private int entranceEnglishScore;

    public Student2() {
        super();
        this.yearOfAdmission = 0;
        this.entranceEnglishScore = 0;
    }

    public void inputAll(Scanner sc) {
        inputCommon(sc);
        yearOfAdmission = Validator.getYearOfAdmission(sc, "Year of admission: ", yearOfBirth);
        entranceEnglishScore = Validator.getIntInRange(sc, "Entrance English score: ", 0, 100);
    }

    public void display() {
        displayCommon();
        System.out.printf(" - %-5d - %d\n", yearOfAdmission, entranceEnglishScore);
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }
}
