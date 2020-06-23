package com.bluedot.pig.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取时间的工具
 * @author xxbb
 */
public class TimeUtil {
    /**
     * 字符串格式年-月-日转java.sql.Date格式
     * @param dateStr 日期字符串
     * @return java.sql.Date日期
     */
    public static java.sql.Date parseToSqlDate(String dateStr){
        try {
            Date date=new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            return new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            throw new RuntimeException("字符串格式转Sql日期格式出错："+e);
        }

    }

    /**
     * 获取日期
     * @return 日期
     */
    public  static String getDate() {
        Date date=new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    /**
     *
     * @return 获取时间
     */
    public static String getTime() {
        Date date=new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(date);
    }

    /**
     * 获取日期时间
     * @return 日期时间
     */
    public static String getDateTime() {
        Date date=new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
