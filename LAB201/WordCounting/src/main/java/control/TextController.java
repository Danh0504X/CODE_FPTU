/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.TextAnalyzer;
import view.TextView;

/**
 *
 * @author ADMIN
 */
public class TextController {
    private TextView view;

    public TextController(TextView view) {
        this.view = view;
    }

    public void run() {
        String content = view.getInput();
        TextAnalyzer analyzer = new TextAnalyzer(content);
        view.showWordCount(analyzer.countWords());
        view.showLetterCount(analyzer.countLetters());
    }
}
