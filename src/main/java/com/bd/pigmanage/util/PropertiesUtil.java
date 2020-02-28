package com.bd.pigmanage.util;

import java.io.*;
import java.util.Properties;

/**
 * 读取配置文件的工具类
 * @author AlwaysXu
 */
public class PropertiesUtil {
    public PropertiesUtil() {

    }

    //获取properties文件对应的值
    public static String getValue(String path, String key) throws Exception {
        // 使用InPutStream流读取properties文件(找不到path文件，无效。)
        // 由于对getSystemResourceAsStream方法不了解，在jsp项目中对path要填的值不清楚(理论上该方法可行)
//        InputStream is = PropertiesUtil.class.getClassLoader().getSystemResourceAsStream(path);
//        System.out.println(is);


        //加载properties的文件内容
        Properties pro = new Properties();
        //使用BufferedReader和FileReader读取
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(path));
        //加载配置文件
        try {
            //pro.load(is);
            pro.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回值
        return pro.getProperty(key);

    }

}
