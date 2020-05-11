package com.bd.pigmanage.util;

/**
 * 读取视图表对应的物理表的工具类
 *
 * @author AlwaysXu
 */
public class TableUtil {
    //properties配置文件在项目中的相对位置
    private final static String RELATIVEPATH = "DataTable.properties";

    /**
     * 获取对应的物理表
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String[] getTables(String key) throws Exception {
        //读取配置文件中值
        String value = PropertiesUtil.getValue(RELATIVEPATH, key);
        //返回存有物理表的字符串数数组
        return value.split("\\.");
    }


}
