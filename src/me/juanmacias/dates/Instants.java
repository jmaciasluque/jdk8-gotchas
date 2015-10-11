package me.juanmacias.dates;


import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Instants {

    public static void main(String[] args) {

        Instant ins = Instant.now();
        ins = ins.plus(10, ChronoUnit.DAYS);
        ins = ins.with(ChronoField.YEAR,2014); // Exception
        System.out.println(ins);


    }

}
