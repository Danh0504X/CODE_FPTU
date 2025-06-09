/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package model;

/**
 *
 * @author ADMIN
 */
public class student {
    private String studentID;
    private String fullName;
    private double gpa;

    public student() {
    }

    
    public student(String studentID, String fullName, double gpa) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.gpa = gpa;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public double getGpa() {
        return gpa;
    }

     public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be empty.");
        }
        this.fullName = fullName;
    }

    public void setStudentID(String studentID) {
        if (studentID == null || studentID.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty.");
        }
        this.studentID = studentID;
    }

    public void setGpa(double gpa) {
        if(gpa < 0 || gpa > 4 ) {
            throw new IllegalArgumentException("Gpa must be > 0 and < 4");
        }
        this.gpa = gpa;
    }

 
    @Override
    public String toString() {
    return String.format("| %-10s | %-20s | GPA: %-4.2f |", studentID, fullName, gpa);
    }   

}
