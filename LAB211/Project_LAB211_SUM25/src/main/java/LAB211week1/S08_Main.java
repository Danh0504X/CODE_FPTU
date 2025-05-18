/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package LAB211week1;
import java.util.Map;
import static LAB211week1.S08_LetterCounter.getValidInput;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class S08_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String userInput = getValidInput(scanner);
        
        S08_LetterCounter analyzer = new S08_LetterCounter(userInput);

        Map<String, Integer> words = analyzer.countWords();
        System.out.println(words);

        Map<Character, Integer> letters = analyzer.countLetters();
        System.out.println(letters);
    }
}
