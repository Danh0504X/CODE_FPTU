/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



public class studentModel {
    private final int MAX = 100; 
    private student[] students = new student[MAX];
    private int size = 0;

    public studentModel() {
        students[size++] = new student("S001", "Alice Johnson", 3.5);
        students[size++] = new student("S002", "Bob Smith", 3.9);
        students[size++] = new student("S003", "Charlie Nguyen", 2.8);
        students[size++] = new student("S004", "Diana Evans", 3.7);
        students[size++] = new student("S005", "Eric Wu", 3.2);
    }

    public student[] getAllStudents() {
        student[] result = new student[size];
        for (int i = 0; i < size; i++) {
            result[i] = students[i];
        }
        return result;
    }
    
    public student findById(String id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getStudentID().equalsIgnoreCase(id)) {
                return students[i];
            }
        }
        return null;
    }
    
    public student findHighestGpaStudent() {
        if (size == 0) return null;
        student top = students[0];
        for (int i = 1; i < size; i++) {
            if (students[i].getGpa() > top.getGpa()) {
                top = students[i];
            }
        }
        return top;
    }
    public student[] getStudentsSortedByGpaDesc() {
        student[] sorted = getAllStudents(); 
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[i].getGpa() < sorted[j].getGpa()) {
                    student temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        return sorted;
    }

}
