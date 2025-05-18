/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week1;

/**
 *
 * @author ADMIN
 */

public class S50_Main {
    public static void main(String[] args) {
        S50_EquationModel model = new S50_EquationModel();
        S50_EquationView view = new S50_EquationView();
        S50_EquationController controller = new S50_EquationController(model, view);
        controller.run();
    }
}

