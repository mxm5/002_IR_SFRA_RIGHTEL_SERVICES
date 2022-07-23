package com.example.sayehwebservices.Utils;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class TimeZoneUtil {
    public static void main(String args[]) {
        System.out.println(getTehranLocalDateTime());
    }

    public static LocalDateTime getTehranLocalDateTime() {
        java.util.TimeZone zone = java.util.TimeZone.getTimeZone("Asia/Tehran");
        String id = zone.getID();
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now.atZone(zone.toZoneId());
        LocalDateTime localDateTimeForTehran = zonedDateTime.toLocalDateTime();
        return localDateTimeForTehran;
    }
}  