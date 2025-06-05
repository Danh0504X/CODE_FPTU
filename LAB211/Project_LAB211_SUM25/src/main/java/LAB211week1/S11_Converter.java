/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week1;

/**
 *
 * @author ADMIN
 */
public class S11_Converter {

    public String convert(String inputValue, int inputBase, int outputBase) {
        int decimal = toDecimal(inputValue, inputBase);
        return fromDecimal(decimal, outputBase);
    }
    
    public int power(int base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent < 0) throw new IllegalArgumentException("Exponent must be non-negative.");

        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    private int toDecimal(String value, int base) {
        int result = 0;
        int exponent = 0;  
        for (int i = value.length() - 1; i >= 0; i--) {
            char ch = value.charAt(i);         
            int digit = charToDigit(ch);
            result += digit * power(base, exponent);
            exponent++; 
        }
        return result;
    }

    private String fromDecimal(int number, int base) {
        if (number == 0) return "0";
        String result = "";
        while (number > 0) {
            int remainder = number % base;
            result = digitToChar(remainder) + result;
            number = number / base;
        }
        return result;
    }

    private int charToDigit(char ch) {
        if (ch >= '0' && ch <= '9') return ch - '0';
        if (ch >= 'A' && ch <= 'F') return 10 + (ch - 'A');
        return 0; 
    }

    private char digitToChar(int digit) {
        if (digit < 10) return (char) ('0' + digit);
        return (char) ('A' + (digit - 10));
    }
}