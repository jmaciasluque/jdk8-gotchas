package me.juanmacias.dates;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;


public class Years {

    public static void main(String[] args) {

        Year y = Year.of(2015);
//        YearMonth ym = y.atMonthDay(MonthDay.of(2, 2));  ===> Compilation error
        LocalDate ym = y.atMonthDay(MonthDay.of(2, 2));
        System.out.println("Year.of(2015).atMonthDay(MonthDay.of(2, 2)) ===> " + ym);

    }

}
