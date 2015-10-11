package me.juanmacias.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimes {

   public static void main(String[] args) {

       // LocalDateTime.of has multiple varieties, down to the primitives for year, month, day, hour, minute, second
       // and nanosecond. Also, the same varieties, but using the Month enum.
       LocalDateTime lct = LocalDateTime.of(LocalDate.of(2015,1,1), LocalTime.of(11, 21));
       lct = lct.withDayOfMonth(12);
       System.out.println(lct.getMonth() + " : " + lct.getDayOfMonth() + " : " + lct.getHour());
       // lct.getMonth() return the month on its enum value... https://docs.oracle.com/javase/tutorial/datetime/iso/enum.html
       // lct.getMonthValue() will return the integer for the month, from 1 to 12
       // lct.getDayOfMonth() returns the day-of-month, from 1 to 31
       // lct.getHour() returns the hour-of-day, from 0 to 23
   }
}