package me.juanmacias.dates;

import java.time.*;
import java.util.Calendar;

public class LocalDates {

   public static void main(String[] args) {

       LocalDate lc = LocalDate.of(2014, 1, 31).now(); // now() is static, so created object with of goes nowhere
       lc.plusYears(2); // lc is a LocalDate, which is immutable, so nothing happens when you invoke this method
       System.out.println(lc + ", two years later? ===> " + lc);

       LocalDate lc1 = LocalDate.of(2014, 1, 31).now(); // now() is static, so created object with of goes nowhere
       LocalDate lc2 = lc1.plusYears(2); // lc1 is a LocalDate, which is immutable, but it'll generate lc2 as we want
       System.out.println(lc1 + ", two years later? ===> " + lc2);

       LocalDate lcThen = LocalDate.of(2014, 1, 31); // of() is static, it creates a LocalDate with arguments
       LocalDate lcThen2 = lcThen.plusYears(2); // lc1 is a LocalDate, which is immutable, but it'll generate lc2 as we want
       System.out.println(lcThen + ", two years later? ===> " + lcThen2);

       LocalDate lcNow = LocalDate.now(); // now() is static, so created object with of goes nowhere
       LocalDate lcNow2 = lcNow.plusYears(2); // lcNow is a LocalDate, which is immutable, but it'll generate lcNow2 as we want
       System.out.println(lcNow + ", two years later ===> " + lcNow2);

       LocalDate now = LocalDate.now();
       System.out.println("now.atTime(Offset) ===> " + now.atTime(OffsetTime.of(LocalTime.now(ZoneId.of("Europe/London")), ZoneOffset.of("Z"))));
//       System.out.println("now.plusHours(long) " + now.plusHours ... DOESN'T EVEN EXIST!
       System.out.println("now.atStartOfDay ===> " + now.atStartOfDay());
//       System.out.println("now.now() " + now.now()); ... DOESN'T EXIST EITHER

       LocalDate lc3 = LocalDate.of(2015, 1, 31).plusMonths(1);
       System.out.println("LocalDate.of(2015, 1, 31).plusMonths(1) ===> " + lc3);  // Pretty cool, isn't it?

       Year y = Year.of(2014);
       LocalDate ym = y.atMonthDay(MonthDay.of(3,3));
       System.out.println("Year.of(2014).atMonthDay(MonthDay.of(3,3)) ===> " + ym);

       /* Java Calendar interface month fields for months are zero based, so 0 represents the month January. But in LocalDate
          class it is not zero based, there 1 means month January. In this case Calendar April has value of 3, so Local date will
          take it as March. At line 7, reducing two months will result instance month to January. */
       LocalDate date = LocalDate.of(2015, Calendar.APRIL, 31);
       date = date.plusMonths(-2);
       System.out.println(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());
   }
}