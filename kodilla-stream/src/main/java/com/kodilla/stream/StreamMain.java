package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBfromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("\nTask 7.1 Beautifier");

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Cat", (anyText) -> "ABC " + anyText + " XYZ");
        poemBeautifier.beautify("Dog", (anyText) -> anyText.toUpperCase());
        poemBeautifier.beautify("Snake", (anyText) -> anyText.replace('n','t'));
        poemBeautifier.beautify("Giraffe", (anyText) -> anyText.substring(0,4).toUpperCase() + "!");


    }
}
