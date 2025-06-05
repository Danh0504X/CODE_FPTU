/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week3;

import java.util.ArrayList;

public class MyStack {
    private ArrayList<Integer> stackValues;

    public MyStack() {
        stackValues = new ArrayList<>();
    }

    public void push(int value) {
        stackValues.add(value);
        System.out.println("Pushed: " + value);
    }

    public void pop() {
        if (stackValues.isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
        } else {
            int removed = stackValues.remove(stackValues.size() - 1);
            System.out.println("Popped: " + removed);
        }
    }

    public void get() {
        if (stackValues.isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            int top = stackValues.get(stackValues.size() - 1);
            System.out.println("Top of stack: " + top);
        }
    }

    public void display() {
        System.out.println("Current stack: " + stackValues);
    }
}
