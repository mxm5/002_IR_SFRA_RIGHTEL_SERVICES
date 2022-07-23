package com.example.sayehwebservices.Utils;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class TimeZoneTester {
    public static void main(String args[]) {
       printTimeZone();


    }

   public static String  printTimeZone() {
      java.util.TimeZone zone = java.util.TimeZone.getTimeZone("Asia/Tehran");
      String id = zone.getID();
      LocalDateTime now = LocalDateTime.now();
      ZonedDateTime zonedDateTime = now.atZone(zone.toZoneId());
      LocalDateTime localDateTimeForTehran = zonedDateTime.toLocalDateTime();
      System.out.println(zonedDateTime);
//      String String = "123456789";  //  true
      return zonedDateTime.toString();
   }
}  