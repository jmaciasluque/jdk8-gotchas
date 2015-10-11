package me.juanmacias.optionals;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Optionals {

    public static void main(String[] args) {

        Stream<String> streams = Stream.of("java","Exam","Oracle");
        Optional<String> ops = streams.findFirst().flatMap(s->Optional.of("A"));
        System.out.println("Stream.of(\"java\",\"Exam\",\"Oracle\").findFirst().flatMap(s->Optional.of(\"A\")) ===> " + ops);

        /* To create an empty optional we have to invoke the 'empty' method so option A is correct.
               public static <T> Optional<T> empty()
           This returns an empty Optional instance. No value is present for this Optional. */
        Optional<String> ops2 = Optional.empty();

        IntStream ints = IntStream.of(3,4,5,6);
//        Optional<Double> avgInts = ints.average();   ===> Compilation error
        OptionalDouble avgInts = ints.average();
        System.out.println(avgInts);

        LongStream longs = LongStream.of(3L,4L,5L,6L);
//        Optional<Double> avgLongs = longs.average();   ===> Compilation error
        OptionalDouble avgLongs = longs.average();
        System.out.println(avgLongs);

        List<Integer> ints2 = new ArrayList<>();
        ints2.add(1);
        ints2.add(2);
        ints2.add(3);
        ints2.add(4);
        Optional<Integer> op1 = Optional.of(ints2.get(2));
        op1.ifPresent(in -> System.out.println(in*2));

        String[] in = new String[3];
//        String op2 = Optional.of(in[2]).orElse("Empty"); ==> Null pointer exception
//        System.out.println(op2);
        String op3 = Optional.ofNullable(in[2]).orElse("Empty");
        System.out.println(op3);
        Optional<String> op4 = Optional.ofNullable(in[2]);
        System.out.println(op4);

        List<String> strings = new ArrayList<>();
        strings.add("Shane");
        strings.add(null);
        strings.add("Rachel");
        strings.add("Raj");
        Optional<String> op11 = Optional.ofNullable(strings.get(2));
        Optional<String> op21 = Optional.ofNullable(strings.get(1));
        System.out.println(op11.get());
        System.out.println(op21.get());

        DoubleStream stream = DoubleStream.of(1.1,2.2,3.3,4.4,5.5);
        Stream<Double> dbs = stream.boxed();
//        Optional<Double> any = dbs.findFirst(d -> d > 1.5);    findFirst() takes NO arguments
//        System.out.println(any);

        List<Integer> ints3 = new ArrayList<>();
        ints3.add(1);
        ints3.add(2);
        ints3.add(3);
        ints3.add(4);
//        Optional<Integer> op5 = Optional.of(ints3.get(2)).orElse(0);   ===> Compilation error!
//        op1.ifPresent(in -> System.out.println(in*2));
    }

}
