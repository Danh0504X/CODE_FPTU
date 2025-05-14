package controller;

import model.student;
import model.studentModel;
import view.studentView;

public class studentController {
    private final studentModel model;
    private final studentView view;

    public studentController(studentModel model, studentView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        while (true) {
            view.showMainMenu();
            String choice = view.prompt("Enter your choice: ");
            
            switch (choice) {
                case "1":
                    view.showAllStudents(model.getAllStudents());
                    break;
                case "2":
                    showStudentWithHighestGpa();
                    break;
                case "3":
                    findStudentById();
                    break;
                case "4":
                    view.showAllStudents(model.getStudentsSortedByGpaDesc());
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
}
