/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.TextController;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        TextView view = new TextView();
        TextController controller = new TextController(view);
        controller.run();
    }
}
