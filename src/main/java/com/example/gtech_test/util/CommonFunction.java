package com.example.gtech_test.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonFunction {

    private CommonFunction(){

    }
    public static String getDateTime(Timestamp date) {
        return date==null ? null : getDateFrom(date, "yyyy-MM-dd HH:mm:ss");
    }
    public static String getDateFrom(Timestamp date, String format) {
        DateFormat formatter = new SimpleDateFormat(format);
        Date newDate = new Date(date.getTime());

        return formatter.format(newDate);
    }
}
