package controller;

import model.student;
import model.LinkedListStudentModel;
import view.studentView;

public class studentController {
    private final LinkedListStudentModel model;
    private final studentView view;

    public studentController(LinkedListStudentModel model, studentView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        while (true) {
            view.showMainMenu();
            String choice = view.prompt("Enter your choice: ");
            
            switch (choice) {
                case "1":
                    addNewStudent();
                    break;
                case "2":
                    view.showAllStudents(model.getAllStudents());
                    break;
                case "3":
                    showStudentWithHighestGpa();
                    break;
                case "4":
                    findStudentById();
                    break;
                case "5":
                    deleteStudentById();            
                    break;
                case "0":
                    view.showMessage("Goodbye!");
                    return;
                default:
                    view.showError("Invalid choice.");
            }
        }
    }

    private void findStudentById() {
        String id = view.prompt("Enter student ID to search: ");
        student found = model.findById(id);
        view.showStudent(found);
    }

    private void showStudentWithHighestGpa() {
        student top = model.findHighestGpaStudent();
        if (top != null) {
            view.showMessage("Student with the highest GPA:");
            view.showStudent(top);
        } else {
            view.showError("Student list is empty.");
        }
    }
    
    private void deleteStudentById() {
        String id = view.prompt("Enter student ID to delete: ");
        model.deleteById(id);
        view.showMessage("Deleted if student existed.");
    }   
    
    private void addNewStudent() {
    String id;
    while (true) {
        id = view.prompt("Enter student ID (format Sxxx, e.g., S001):");
        if (id.matches("S\\d{3}")) {
            if (model.findById(id) != null) {
            view.showMessage("Student ID already exists. Please enter a unique ID.");
            continue;
            }
            break;
        } else {
            view.showMessage("Invalid ID. Format must be S followed by 3 digits (e.g., S001).");
        }
    }    
    
    String fullName;
    while (true) {
        fullName = view.prompt("Enter Student Name: ");
        if (fullName.matches("[a-zA-Z\\s]+")) {
            break;
        } else {
            view.showMessage("Invalid name. Please enter letters only (no numbers or special characters).");
        }
    }

    double gpa;
    while (true) {
        try {
            String gpaInput = view.prompt("Enter GPA:");
            gpa = Double.parseDouble(gpaInput);
            if (gpa >= 0.0 && gpa <= 4.0) {
                break;
            } else {
                view.showMessage("GPA must be between 0.0 and 4.0.");
            }
        } catch (NumberFormatException e) {
            view.showMessage("Invalid GPA. Please enter a valid number.");
        }
    }

    student s = new student(id, fullName, gpa);
    model.add(s);
}
}
