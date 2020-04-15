package com.codeorange.api.management.customerservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date getDateFromString(String stringDate) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            Date date = f.parse(stringDate.substring(0, 18));
            return date;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
