package com.pls.accesstoken.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间工具类
 * Created by 81046 on 2018-07-12
 */
public class DateUtil {
    /** 时间格式(yyyy-MM-dd) */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /** 时间格式(yyyy-MM-dd HH:mm:ss) */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static Date str2Date(String str) {
        return str2Date(str, null);
    }

    public static Date str2Date(String str, String format) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = DATE_TIME_PATTERN;
        }
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;

    }

    public static String format(Date date) {
        return format(date, DATE_TIME_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
    public static String date2Str(Calendar c) {// yyyy-MM-dd HH:mm:ss
        return date2Str(c, null);
    }

    public static String date2Str(Calendar c, String format) {
        if (c == null) {
            return null;
        }
        return date2Str(c.getTime(), format);
    }
    public static String date2Str(Date d, String format) {// yyyy-MM-dd HH:mm:ss
        if (d == null) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = DATE_TIME_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(d);
        return s;
    }
    public static Date dateAddOneDay(Date d){
        Calendar   calendar   =   new GregorianCalendar();
        calendar.setTime(d);
        calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        d=calendar.getTime();
        return d;
    }
    public static Date dateOnly(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        String pre = sdf.format(d);
        String dateStr = pre + " 12:00:00";

        return str2Date(dateStr, null);
    }

}
