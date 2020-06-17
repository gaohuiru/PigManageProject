package com.bluedot.pig.util;

/**
 * 用于获取增删改查语句中包含的数据库表名并将数据库表名转化为对应的Po类名
 * @author AlwaysXu
 */
public class PoUtil {
    /**
     * /从SQL语句中涉及物理表的前一个单词开始截取字符串
     * 截取后的字符串方便分割出需要的Po类名
     * @param sql
     * @return
     */
    public static String getClassName(String sql){
        //从SQL语句中涉及物理表的前一个单词开始截取字符串
        //增删改查分别对应的是 from from update select
        //如select * from pig where id=1,会截取from pig where id=1，方便之后截取出物理表名的字段
        //判断该字段是否存在，同时查询该字段出现的位置用于分割字符串
            //查询或删除的语句
        String str=null;
        if(sql.contains("from")) {
            str = sql.substring(sql.indexOf("from"));
        }
            //插入的语句
        if(sql.contains("into")){
            str=sql.substring(sql.indexOf("into"));
        }
            //修改的语句
        if(sql.contains("update")){
            str=sql.substring(sql.indexOf("update"));
        }
        //以空格分割，字符串数组中的第二个元素即为物理表名
        String[] strs= str.split("\\s+");
        //将物理表名转化为Po类名的形式
        str=StyleUtil.lineToHump(strs[1]);
        return str;
    }

    public static void main(String[] args) {
        String sql1="select * from pig_select";
        String sql2="insert into pig_into";
        String sql3="update pig_update";
        String sql4="delete from pig_delete";
        System.out.println(getClassName(sql1));
        System.out.println(getClassName(sql2));
        System.out.println(getClassName(sql3));
        System.out.println(getClassName(sql4));
    }
}
