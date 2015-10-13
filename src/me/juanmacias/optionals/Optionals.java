package me.juanmacias.optionals;

import me.juanmacias.utils.Printer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class Optionals extends Printer {

    public static void main(String[] args) {

        Optional optional1 = Optional.empty();
        println("Optional.empty() ==> " + optional1);
        println("Optional.empty().isPresent() ==> throws NoSuchElementException");
        println("Optional.empty().equals(null) ==> " + optional1.equals(null));
        println("Optional.empty().get() ==> throws NoSuchElementException");
        optional1.ifPresent(o -> System.out.print("print if present"));
        println("Optional.empty().ifPresent(o -> {System.out.print(\"print if present\");});");
        println("Optional.empty().orElse(\"orElseElement\") ==> " + optional1.orElse("orElseElement"));
        println("Optional.empty().orElseGet(() -> \"orElseGetElement\") ==> " + optional1.orElseGet(() -> "orElseGetElement"));
        println("Optional.empty().orElseThrow(() -> new RuntimeException(\"orElseThrow exception\")) ==> compilation unhandled exception error!");
        println("Optional.empty().map(i -> {println(\"mapping\");return \"mappedValue\";}) ==> " + optional1.map(i -> {println("mapping");return "mappedValue";}));

        Optional optional2 = Optional.of("aString");
        println("\nOptional.of(null) ==> throws NullPointerException");
        println("Optional.of(\"aString\") ==> " + optional2);
        println("Optional.of(\"aString\").isPresent() ==> " + optional2.isPresent());
        println("Optional.of(\"aString\").equals(null) ==> " + optional2.equals(null));
        println("Optional.of(\"aString\").equals(\"aString\") ==> " + optional2.equals("aString"));
        println("Optional.of(\"aString\").equals(Optional.of(\"aString\")) ==> " + optional2.equals(Optional.of("aString")));
        println("Optional.of(\"aString\").get() ==> " + optional2.get());
        optional2.ifPresent(o -> System.out.print("print if present -> "));
        println("Optional.of(\"aString\").ifPresent(o -> {System.out.print(\"print if present\");});");
        println("Optional.of(\"aString\").orElse(\"orElseElement\") ==> " + optional2.orElse("orElseElement"));
        println("Optional.of(\"aString\").orElseGet(() -> \"orElseGetElement\") ==> " + optional2.orElseGet(() -> "orElseGetElement"));
        println("Optional.of(\"aString\").orElseThrow(() -> new RuntimeException(\"orElseThrow exception\")) ==> compilation unhandled exception error!");
        println("Optional.of(\"aString\").map(i -> {println(\"mapping\");return \"mappedValue\";}) ==> " + optional2.map(i -> {print("mapping -> ");return "mappedValue";}));
        println("Optional.of(\"aString\").map(i -> {println(\"mapping\");return \"mappedValue\";}).get() ==> " + optional2.map(i -> {print("mapping -> ");return "mappedValue";}).get());

        Optional optional3 = Optional.ofNullable("aString");
        println("\nOptional.ofNullable(null) ==> " + Optional.ofNullable(null));
        println("Optional.ofNullable(\"aString\") ==> " + optional3);
        println("Optional.ofNullable(\"aString\").isPresent() ==> " + optional3.isPresent());
        println("Optional.ofNullable(\"aString\").equals(null) ==> " + optional3.equals(null));
        println("Optional.ofNullable(\"aString\").equals(\"aString\") ==> " + optional3.equals("aString"));
        println("Optional.ofNullable(\"aString\").equals(Optional.ofNullable(\"aString\")) ==> " + optional3.equals(Optional.ofNullable("aString")));
        println("Optional.ofNullable(\"aString\").get() ==> " + optional3.get());
        optional3.ifPresent(o -> System.out.print("print if present -> "));
        println("Optional.ofNullable(\"aString\").ifPresent(o -> {System.out.print(\"print if present\");});");
        println("Optional.ofNullable(\"aString\").orElse(\"orElseElement\") ==> " + optional3.orElse("orElseElement"));
        println("Optional.ofNullable(\"aString\").orElseGet(() -> \"orElseGetElement\") ==> " + optional3.orElseGet(() -> "orElseGetElement"));
        println("Optional.ofNullable(\"aString\").orElseThrow(() -> new RuntimeException(\"orElseThrow exception\")) ==> compilation unhandled exception error!");
        println("Optional.ofNullable(\"aString\").map(i -> {println(\"mapping\");return \"mappedValue\";}) ==> " + optional3.map(i -> {print("mapping -> ");return "mappedValue";}));
        println("Optional.ofNullable(\"aString\").map(i -> {println(\"mapping\");return \"mappedValue\";}).get() ==> " + optional3.map(i -> {print("mapping -> ");return "mappedValue";}).get());

        Stream<String> streams = Stream.of("a","random","stream");
        Optional<String> optional4 = streams.findFirst().flatMap(s -> Optional.of("A"));
        println("\nStream.of(\"a\",\"random\",\"stream\").findFirst().flatMap(s -> Optional.of(\"A\")) ===> " + optional4);

        List<String> strings = new ArrayList<>();
        strings.add("One");
        strings.add(null);
        strings.add("Three");
        strings.add("Four");
        println("\nstrings ==> " + strings);
        println("Optional.ofNullable(strings.get(0)) ==> " + Optional.ofNullable(strings.get(0)));
        println("Optional.ofNullable(strings.get(1)) ==> " + Optional.ofNullable(strings.get(1)));
        println("Optional.ofNullable(strings.get(0)).get() ==> " + Optional.ofNullable(strings.get(0)).get());
        println("Optional.ofNullable(strings.get(1)).get() ==> throws NoSuchElementException");
    }
}