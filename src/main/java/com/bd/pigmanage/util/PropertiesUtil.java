package com.bd.pigmanage.util;

import sun.dc.pr.PRError;

import java.io.*;
import java.net.URL;
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
     * TODO 需要读取配置文件逻辑，不需要提前去找配置文件位置
     * 获取properties文件对应的值
     *
     * @param propertiesName 配置文件名称
     * @param key
     * @return
     * @throws Exception
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
