/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week4;

import java.util.Scanner;

public class Person {
    protected String id;
    protected String fullName;
    protected String phoneNumber;
    protected int yearOfBirth;
    protected String major;

    public Person() {
        this.id = "";
        this.fullName = "";
        this.phoneNumber = "";
        this.yearOfBirth = 0;
        this.major = "";
    }

    public void inputCommon(Scanner sc) {
        id = Validator.getID(sc, "ID: ");
        fullName = Validator.getFullName(sc, "Fullname: ");
        phoneNumber = Validator.getPhoneNumber(sc, "Phone number: ");
        yearOfBirth = Validator.getYearOfBirth(sc, "Year of birth: ");
        major = Validator.getMajor(sc, "Major: ");
    }

    public void displayCommon() {
        System.out.printf("%-10s - %-20s - %-15s - %-10d - %-20s",
                id, fullName, phoneNumber, yearOfBirth, major);
    }

    public String getFullName() {
        return fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
