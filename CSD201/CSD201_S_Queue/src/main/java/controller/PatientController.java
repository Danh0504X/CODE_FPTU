/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;
import view.PatientView;

/**
 *
 * @author ADMIN
 */
public class PatientController {
    private PatientQueueModel model;
    private PatientView view;

    public PatientController(PatientQueueModel model, PatientView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        while (true) {
            int choice = view.showMenu();
            switch (choice) {
                case 1:
                    Patient p = view.inputPatientInfo();
                    model.registerPatient(p);
                    break;
                case 2:
                    Patient next = model.processPatient();
                    view.showPatient(next);
                    break;
                case 3:
                    view.showQueue(model.getAllPatients());
                    break;
                case 0:
                    view.showMessage("Thoat chuong trinh.");
                    return;
                default:
                    view.showMessage(">> Lua chon khong hop le.");
            }
        }
    }
}
