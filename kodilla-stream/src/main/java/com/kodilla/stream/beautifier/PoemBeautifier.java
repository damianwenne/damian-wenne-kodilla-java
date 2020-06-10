package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String anyText, PoemDecorator poemDecorator) {
        String beautifiedWord = poemDecorator.decorate(anyText);
        System.out.println("Beautified word: " + beautifiedWord);
    }
}
