package com.bd.pigmanage.util;

import java.io.*;
import java.util.Properties;

/**
 * 读取配置文件的工具类
 */
public class PropertiesUtil {
    public  PropertiesUtil(){

    }

    //获取properties文件对应的值
    public String getValue(String path, String key) throws Exception {
        //加载properties的文件内容
        Properties pro = new Properties();
        // 使用InPutStream流读取properties文件
//        InputStream is = this.getClass().getClassLoader().getSystemResourceAsStream(path);
//        System.out.println(is);



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
