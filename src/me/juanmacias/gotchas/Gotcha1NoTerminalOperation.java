package me.juanmacias.gotchas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Gotcha1NoTerminalOperation {

    public static void main(String[] args) {

        List<String> eulogy = Arrays.asList("yo", "quiero", "ser", "llorando", "el", "hortelano");

        Stream<String> eulogyStream = eulogy.stream().filter(word -> {
            System.out.println("while filtering (intermediate operation)... " + word);
            return word.contains("a");
        }).map(word -> {
            System.out.println("while uppercasing (intermediate operation)... " + word);
            return word.toUpperCase();
        });

//        eulogyStream.peek(word -> System.out.println("peeking before counting (terminal operation)... " + word)).count();
    }
}