package me.juanmacias.dates;

import java.time.Duration;
import java.time.LocalTime;


public class Durations {

    public static void main(String[] args) {

        LocalTime start = LocalTime.of(21,10);
        LocalTime end = LocalTime.of(12,12);
        Duration duration1 = Duration.between(start, end);
        long duration1Hours = duration1.toHours();
        System.out.println("Duration.between(LocalTime.of(21,10), LocalTime.of(12, 12)).toHours() ===> " + duration1Hours);
        System.out.println("Duration.between(LocalTime.of(21,10), LocalTime.of(12, 12)) ===> " + duration1);

        Duration duration2 = Duration.between(end, start);
        long duration2Hours = duration2.toHours();
        System.out.println("Duration.between(LocalTime.of(12, 12), LocalTime.of(21,10)).toHours() ===> " + duration2Hours);
        System.out.println("Duration.between(LocalTime.of(12, 12), LocalTime.of(21,10)) ===> " + duration2);

    }

}
