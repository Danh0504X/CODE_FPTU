/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de190155.project_lab211_sum25;

/**
 *
 * @author ADMIN
 */

public class mayTinh {
    private double memory;

    public mayTinh(double memory) {
        this.memory = memory;
    }

    public mayTinh() {
    }
    
    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }
    
    public double changeMemory(String op, double so) {
    switch (op) {
        case "+":
            memory += so;
            break;
        case "-":
            memory -= so;
            break;
        case "*":
            memory *= so;
            break;
        case "/":
            if (so == 0) throw new ArithmeticException("Cannot divide by zero");
            memory /= so;
            break;
        case "^":
            memory = Math.pow(memory, so);
            break;
        case "=":
            break;
        default:
            throw new IllegalArgumentException("Invalid operator: " + op);
    }
    return memory;
    }
}
