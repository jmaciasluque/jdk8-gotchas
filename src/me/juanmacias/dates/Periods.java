package me.juanmacias.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class Periods {

    public static void main(String[] args) {

        Period p = Period.ofMonths(2);
        p = p.plusYears(1);
        p = p.withYears(2);
        System.out.println("Period.ofMonths(2).plusYears(1).withYears(2) ===> " + p); // self-explanatory!

        LocalDate ldt = LocalDate.of(2015, 11, 12);
        Period duration = Period.ofMonths(3).plusYears(-1);
        ldt = ldt.plus(duration);
        System.out.println("LocalDate.of(2015, 11, 12).plus(Period.ofMonths(3).plusYears(-1)) ===> " + ldt);

        LocalDateTime d = LocalDateTime.of(2014, 1, 1, 21, 10, 33);
        Period future = Period.of(1, 1, 1);
        d = d.plus(future);
        DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(d.format(format));

        Period period = Period.of(1, 2, 1);
        LocalDate loc = LocalDate.of(2015, 1, 1);
        loc = loc.plusDays(period.getDays());
        System.out.println(loc);

    }
}