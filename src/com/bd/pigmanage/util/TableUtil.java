package com.bd.pigmanage.util;

/**
 * 读取视图表对应的物理表的工具类
 */
public class TableUtil {
    //获取物理表需访问的配置文件路径
    private final static String PATH=
            "D:\\javahome\\PigManageProject\\src\\com\\bd\\pigmanage\\table.properties";

    public TableUtil(){

    }

    //获取对应的物理表
    public static String[] getTables(String key) throws Exception {
        String value=PropertiesUtil.getValue(PATH,key);
        return value.split("\\.");

    }
}
