/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



public class LinkedListStudentModel {
    private class Node {
        student data;
        Node next;

        Node(student data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    public LinkedListStudentModel() {
        add(new student("S001", "Alice Johnson", 3.5));
        add(new student("S002", "Bob Smith", 3.9));
        add(new student("S003", "Charlie Nguyen", 2.8));
        add(new student("S004", "Diana Evans", 3.7));
        add(new student("S005", "Eric Wu", 3.2));
    }
    
    public void add(student s) {
        Node newNode = new Node(s);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    public student[] getAllStudents() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        student[] result = new student[count];
        current = head;
        int i = 0;
        while (current != null) {
            result[i++] = current.data;
            current = current.next;
        }
        return result;
    }
    
    public student findById(String id) {
        Node current = head;
        while (current != null) {
            if (current.data.getStudentID().equalsIgnoreCase(id)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
    
    public void deleteById(String id) {
        if (head == null) return;
        if (head.data.getStudentID().equalsIgnoreCase(id)) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && !current.next.data.getStudentID().equalsIgnoreCase(id)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
    
    public student findHighestGpaStudent() {
        if (head == null) return null;
        student top = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data.getGpa() > top.getGpa()) {
                top = current.data;
            }
            current = current.next;
        }
        return top;
    }
}
