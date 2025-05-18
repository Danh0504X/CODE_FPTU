/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week1;

import java.util.List;
import java.util.Scanner;

public class S50_EquationView {
    private final Scanner sc = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n========= EQUATION SOLVER =========");
        System.out.println("1. Solve linear equation (Ax + B = 0)");
        System.out.println("2. Solve quadratic equation (Ax^2 + Bx + C = 0)");
        System.out.println("3. Exit");
    }

    public String prompt(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showError(String error) {
        System.out.println("Error: " + error);
    }

    public void showSolutions(List<Float> solutions) {
        if (solutions == null) {
            showMessage("No solution.");
        } else if (solutions.isEmpty()) {
            showMessage("Infinite solutions.");
        } else {
            for (Float x : solutions) {
                showMessage("x = " + x);
            }
        }
    }

    public void showAnalysis(List<Float> inputs, EquationAnalyzer analyzer) {
        showMessage("Even numbers:");
        inputs.stream().filter(analyzer::isEven).forEach(System.out::println);
        showMessage("Odd numbers:");
        inputs.stream().filter(analyzer::isOdd).forEach(System.out::println);
        showMessage("Perfect squares:");
        inputs.stream().filter(analyzer::isPerfectSquare).forEach(System.out::println);
    }

    // Giao diện gọi hàm kiểm tra số
    public interface EquationAnalyzer {
        boolean isEven(float n);
        boolean isOdd(float n);
        boolean isPerfectSquare(float n);
    }
}
