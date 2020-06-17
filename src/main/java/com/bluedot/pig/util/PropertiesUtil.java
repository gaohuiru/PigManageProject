package com.bluedot.pig.util;

import java.io.*;
import java.util.Properties;

/**
 * 读取配置文件的工具类
 *
 * @author AlwaysXu
 */
public class PropertiesUtil {
    public static void main(String[] args) throws Exception {
       getValue(null, null);
    }

    /**
     * 获取properties文件对应的值
     *
     * @param propertiesName 配置文件名称
     * @param key 键名
     * @return 键值
     * @throws Exception 异常
     */
    public static String getValue(String propertiesName, String key) throws Exception {
        // 之前一直使用：PropertiesUtil.class.getClassLoader().getSystemResourceAsStream(path)导致获取不到配置文件
        InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesName);
        System.out.println(is);
        //加载properties的文件内容
        Properties pro = new Properties();
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回值
        return pro.getProperty(key);

    }

}
