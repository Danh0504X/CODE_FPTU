package App;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import controller.studentController;
import model.LinkedListStudentModel;
import view.studentView;

public class main {
    public static void main(String[] args) {
        LinkedListStudentModel model = new LinkedListStudentModel();
        studentView view = new studentView();
        studentController controller = new studentController(model, view);
        controller.run();
    }
}
