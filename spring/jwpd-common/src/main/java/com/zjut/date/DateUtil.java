package com.zjut.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yuanweipeng
 */
public final class DateUtil {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private DateUtil(){}

    public static Date addDay(Date date, int count) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, count);
        return calendar.getTime();
    }

    public static String getFormatDate(Date date) {
        String result = "";
        if (date != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
            result = simpleDateFormat.format(date);
        }
        return result;
    }

    public static Date parse(String date) throws Exception {

        if (date == null) {
            throw new Exception("empty date exception!");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

        return simpleDateFormat.parse(date);
    }


}
