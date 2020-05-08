package com.bd.pigmanage.util;

import sun.dc.pr.PRError;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * 读取配置文件的工具类
 * @author AlwaysXu
 */
public class PropertiesUtil {
    public static void main(String[] args) throws Exception {
        PropertiesUtil propertiesUtil=new PropertiesUtil();
        getValue(null,null);
    }

    /**
     * TODO 需要读取配置文件逻辑，不需要提前去找配置文件位置
     * 获取properties文件对应的值
     * @param path 配置文件路径
     * @param key
     * @return
     * @throws Exception
     */
    public static String getValue(String path, String key) throws Exception {
        // 使用InPutStream流读取properties文件(找不到path文件，返回is为空)
        // 莫名奇妙
        // InputStream is = Properties.class.getClassLoader().getResourceAsStream("DataTable.properties");
        // URL resource = PropertiesUtil.class.getClassLoader().getResource("DataTable.properties");
        // System.out.println(resource);

        //加载properties的文件内容
        Properties pro = new Properties();
        //使用BufferedReader和FileReader读取
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(path));
        //加载配置文件
        try {
            pro.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回值
        return pro.getProperty(key);

    }

}
