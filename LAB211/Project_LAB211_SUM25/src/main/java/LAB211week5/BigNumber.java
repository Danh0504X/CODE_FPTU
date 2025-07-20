/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week5;

import java.util.ArrayList;

public class BigNumber {
    private ArrayList<Integer> digits;

    public BigNumber(String number) {
        digits = new ArrayList<>();
        for (int i = number.length() - 1; i >= 0; i--) {
            digits.add(number.charAt(i) - '0');
        }
    }

    public BigNumber(ArrayList<Integer> digits) {
        this.digits = digits;
    }

    public BigNumber add(BigNumber other) {
        ArrayList<Integer> result = new ArrayList<>();
        int carry = 0;
        int maxLength = Math.max(digits.size(), other.digits.size());

        for (int i = 0; i < maxLength; i++) {
            int a = (i < digits.size()) ? digits.get(i) : 0;
            int b = (i < other.digits.size()) ? other.digits.get(i) : 0;
            int sum = a + b + carry;
            result.add(sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) result.add(carry);

        return new BigNumber(result);
    }

    public BigNumber multiply(BigNumber other) {
        int[] result = new int[digits.size() + other.digits.size()];

        for (int i = 0; i < digits.size(); i++) {
            for (int j = 0; j < other.digits.size(); j++) {
                result[i + j] += digits.get(i) * other.digits.get(j);
                if (result[i + j] >= 10) {
                    result[i + j + 1] += result[i + j] / 10;
                    result[i + j] %= 10;
                }
            }
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        int lastIndex = result.length - 1;
        while (lastIndex > 0 && result[lastIndex] == 0) lastIndex--;

        for (int i = 0; i <= lastIndex; i++) {
            resultList.add(result[i]);
        }

        return new BigNumber(resultList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = digits.size() - 1; i >= 0; i--) {
            sb.append(digits.get(i));
        }
        return sb.toString();
    }
}
