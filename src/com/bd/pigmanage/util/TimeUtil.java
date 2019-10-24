package com.bd.pigmanage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取时间的工具
 * @author xxbb
 */
public class TimeUtil {
    public TimeUtil() {
        // TODO Auto-generated constructor stub
    }
    //获取日期

    public  static String getDate() {
        Date date=new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        String strDate=dateFormat.format(date);
        return strDate;
    }
    //获取时间
    public static String getTime() {
        Date date=new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("HH:mm:ss");
        String strTime=dateFormat.format(date);
        return strTime;
    }
    //获取日期时间
    public static String getDateTime() {
        Date date=new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDateTime=dateFormat.format(date);
        return strDateTime;
    }
}
