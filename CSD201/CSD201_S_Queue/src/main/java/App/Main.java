/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package App;

import controller.*;
import model.*;
import view.*;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        PatientQueueModel model = new PatientQueueModel();
        PatientView view = new PatientView();
        PatientController controller = new PatientController(model, view);
        controller.run();
    }
}

