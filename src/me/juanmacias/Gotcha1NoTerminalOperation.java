package me.juanmacias;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Gotcha1NoTerminalOperation {

    public static void main(String[] args) {

        List<String> eulogy = Arrays.asList("yo", "quiero", "ser", "llorando", "el", "hortelano");

        Stream<String> eulogyStream = eulogy.stream().filter( word -> {
            System.out.println(word);
            return word.contains("a");
        });

//        System.out.println(eulogyStream.count() + " words contain the letter a");
    }
}