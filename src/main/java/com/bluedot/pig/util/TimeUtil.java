package com.bluedot.pig.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取时间的工具
 * @author xxbb
 */
public class TimeUtil {

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
