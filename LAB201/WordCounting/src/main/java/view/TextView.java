/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Map;
import java.util.Scanner;

public class TextView {
    private Scanner scanner = new Scanner(System.in);

    public String getInput() {
        System.out.print("Enter your content:\n");
        return scanner.nextLine();
    }

    public void showWordCount(Map<String, Integer> wordCount) {
        System.out.println(wordCount);
    }

    public void showLetterCount(Map<Character, Integer> letterCount) {
        System.out.println(letterCount);
    }
}
