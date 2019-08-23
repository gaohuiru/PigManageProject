package com.bd.pigmanage.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    /**
     *
     * @param path properties文件路径
     * @param key 键名
     * @return value键名对应的值
     * @throws IOException
     */
    public static String getValue(String path,String key){
        //加载properties的文件内容
        Properties pro = new Properties();
        ClassLoader cl = PropertiesUtil.class.getClassLoader();
        InputStream is = ClassLoader.getSystemResourceAsStream(path);
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取对应值
        return pro.getProperty(key);

    }

    public static void main(String[] args) {
        String value=PropertiesUtil.getValue("com/bd/pigmanage/table.properties","pigInfo");
        System.out.println(value);
        String[] tables=value.split("\\.");
        for(String table:tables){
            System.out.println(table);
        }
    }
}
