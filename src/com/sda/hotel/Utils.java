package com.sda.hotel;

import java.util.Calendar;

public class Utils {

    public static Calendar setCalendar(int an, int luna, int zi){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, an);
        calendar.set(Calendar.MONTH, luna);
        calendar.set(Calendar.DAY_OF_MONTH, zi);
        calendar.set(Calendar.HOUR, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }
}
