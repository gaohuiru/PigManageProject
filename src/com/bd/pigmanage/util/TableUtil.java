package com.bd.pigmanage.util;

/**
 * 读取视图表对应的物理表的工具类
 * @author AlwaysXu
 */
public class TableUtil {
    //properties配置文件在项目中的相对位置
    private final static String RELATIVEPATH="resource/DataTable.properties";

    public TableUtil(){

    }

    //获取对应的物理表
    public static String[] getTables(String key) throws Exception {
        //获取该类的路径，用于截取出项目路径以适配不同的电脑
        String absolutePath=TableUtil.class.getClassLoader().getResource("").getPath().substring(1);
        //通过sqlit截取出保存项目路径的字符串
        String[] projectPaths=absolutePath.split("out/artifacts/PigManage_war_exploded/WEB-INF/classes/");
        //将项目路径和配置文件的相对路径组合
        String path=projectPaths[0]+RELATIVEPATH;
        System.out.println("组合后的路径: "+path);
        //读取配置文件中值
        String value=PropertiesUtil.getValue(path,key);
        //返回存有物理表的字符串数数组
        return value.split("\\.");
    }
}
