package me.juanmacias.dates;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Zones {

    public static void main(String[] args) {

//        ZoneId zone = ZoneId.get("Asia/Colombo");             ALL COMPILATION ERRORS!
//        ZoneId zone = new ZoneId("Asia/Colombo");
//        ZoneId zone = ZoneId.systemDefault("Asia/Colombo");
//        ZoneId zone = ZoneId.apply("Asia/Colombo");
        ZoneId zone = ZoneId.of("Asia/Colombo");

        LocalDate date = LocalDate.of(2013, 11, 20);
        ZoneId zid = ZoneId.of("Europe/Paris");
        // only one correct, the others: compilation errors!
//        ZonedDateTime ztd = ZonedDateTime.of(date, zid);
//        ZonedDateTime ztd = ZonedDateTime.get(date, zid);
        ZonedDateTime ztd = ZonedDateTime.of(date.atTime(12, 00), zid);
//        ZonedDateTime ztd = ZonedDateTime.dateTime(date.atTime(12, 00), zid);
//        ZonedDateTime ztd = zid.of(date);
        System.out.println(ztd.getHour());
    }

}
