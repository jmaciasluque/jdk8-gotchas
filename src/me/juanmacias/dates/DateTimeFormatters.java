package me.juanmacias.dates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatters {

    public static void main(String[] args) {

        LocalDate ldt = LocalDate.of(2015, 1, 12);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/M/yyyy");
        System.out.println(ldt.format(format));

        LocalDate ldt1 = LocalDate.of(2015, 11, 12);
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/M/yyyy");
        System.out.println(ldt1.format(format1));

        LocalDate ldt2 = LocalDate.of(2015, 1, 12);
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(ldt2.format(format2));

        LocalTime time = LocalTime.of(11, 22);
        time.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("LocalTime.of(11, 22).format(DateTimeFormatter.ISO_LOCAL_TIME) ===> " + time);

    }
}
