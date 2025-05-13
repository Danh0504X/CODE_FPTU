/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package model;

import java.util.*;

public class TextAnalyzer {
    private String content;

    public TextAnalyzer(String content) {
        this.content = content;
    }

    public Map<String, Integer> countWords() {
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    public Map<Character, Integer> countLetters() {
        Map<Character, Integer> letterCount = new TreeMap<>();
        for (char c : content.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
        }
        return letterCount;
    }
}

