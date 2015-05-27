package com.ntu.pms.utils;

import java.util.Calendar;

public class DateUtil {

    public static String getMonthDay(Calendar calendar) {
        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String day = String.valueOf(calendar.get(Calendar.DATE));
        if (month.length() != 2) {
            month = "0" + month;
        }
        if (day.length() != 2) {
            day = "0" + day;
        }
        return month + "/" + day;
    }

}
