/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week2;

/**
 *
 * @author ADMIN
 */
public enum S51_Operator {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"), POWER("^"), EQUAL("=");

    private final String symbol;

    S51_Operator(String symbol) {
        this.symbol = symbol;
    }

    public static S51_Operator fromString(String str) {
        for (S51_Operator op : values()) {
            if (op.symbol.equals(str)) return op;
        }
        return null;
    }
}
