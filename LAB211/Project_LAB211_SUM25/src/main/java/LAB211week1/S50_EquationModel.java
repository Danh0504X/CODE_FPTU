/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week1;

import java.util.*;

public class S50_EquationModel {

    public List<Float> solveLinear(float a, float b) {
        if (a == 0) {
            if (b == 0) return new ArrayList<>(); 
            return null; 
        }
        return Collections.singletonList(-b / a);
    }

    public List<Float> solveQuadratic(float a, float b, float c) {
        if (a == 0) return solveLinear(b, c);
        float delta = b * b - 4 * a * c;
        if (delta < 0) return null;
        float sqrt = (float) Math.sqrt(delta);
        float x1 = (-b + sqrt) / (2 * a);
        float x2 = (-b - sqrt) / (2 * a);
        if (x1 == x2) return Collections.singletonList(x1);
        return Arrays.asList(x1, x2);
    }

    public boolean isEven(float num) {
        return num % 2 == 0;
    }

    public boolean isOdd(float num) {
        return num % 2 != 0;
    }

    public boolean isPerfectSquare(float num) {
        if (num < 0) return false;
        double sqrt = Math.sqrt(num);
        return sqrt == Math.floor(sqrt);
    }

    public boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

