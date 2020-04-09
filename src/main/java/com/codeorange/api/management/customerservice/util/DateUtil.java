package com.codeorange.api.management.customerservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    public static Integer getAgeFromBirthDate(String birthDate) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = f.parse(birthDate.substring(0, 9));
            LocalDate l = date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            Period diff = Period.between(l, LocalDate.now());
            return diff.getYears();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
