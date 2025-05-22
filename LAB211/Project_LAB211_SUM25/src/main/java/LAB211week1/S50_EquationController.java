/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week1;

import java.util.*;

public class S50_EquationController {
    private final S50_EquationModel model;
    private final S50_EquationView view;

    public S50_EquationController(S50_EquationModel model, S50_EquationView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        while (true) {
            view.showMenu();
            String choice = view.prompt("Enter choice: ");
            switch (choice) {
                case "1":
                    solveLinear();
                    break;
                case "2":
                    solveQuadratic();
                    break;
                case "3":
                    view.showMessage("Exiting program...");
                    return;
                default:
                    view.showError("Invalid choice.");
            }
        }
    }

    private void solveLinear() {
        view.showMessage("=== Solving Superlative Equation: Ax + B = 0 ===");

        float a = getFloat("Enter A: ");
        float b = getFloat("Enter B: ");

        List<Float> result = model.solveLinear(a, b);
        view.showSolutions(result);

        List<Float> inputs = List.of(a, b);
        view.showMessage("Even numbers:");
        inputs.stream().filter(model::isEven).forEach(System.out::println);
        view.showMessage("Odd numbers:");
        inputs.stream().filter(model::isOdd).forEach(System.out::println);
        view.showMessage("Perfect square numbers:");
        inputs.stream().filter(model::isPerfectSquare).forEach(System.out::println);
    }
    
    private void solveQuadratic() {
        view.showMessage("=== Solving Quadratic Equation: Ax^2 + Bx + C = 0 ===");

        float a = getFloat("Enter coefficient A: ");
        float b = getFloat("Enter coefficient B: ");
        float c = getFloat("Enter coefficient C: ");

        // Giải phương trình
        List<Float> result = model.solveQuadratic(a, b, c);

        // Hiển thị nghiệm
        if (result == null) {
            view.showMessage("No real solution (discriminant < 0).");
        } else if (result.size() == 1) {
            view.showMessage("Equation has one real root:");
            view.showSolutions(result);
        } else {
            view.showMessage("Equation has two real roots:");
            view.showSolutions(result);
        }

        List<Float> inputs = List.of(a, b, c);

        view.showMessage("=== Even numbers among A, B, C ===");
        inputs.stream().filter(model::isEven).forEach(System.out::println);

        view.showMessage("=== Odd numbers among A, B, C ===");
        inputs.stream().filter(model::isOdd).forEach(System.out::println);

        view.showMessage("=== Perfect square numbers among A, B, C ===");
        inputs.stream().filter(model::isPerfectSquare).forEach(System.out::println);
    }
   

    private float getFloat(String msg) {
        while (true) {
            String input = view.prompt(msg);
            if (model.isFloat(input)) return Float.parseFloat(input);
            view.showError("Not a valid number. Try again.");
        }
    }
}
