package com.bd.pigmanage.test;

import com.bd.pigmanage.util.DbUtil;
import com.bd.pigmanage.util.PropertiesUtil;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    public Test(){

    }


    public Test(String sql){
        //分析sql语句，调用对应方法
        String method= sql.substring(0,6);
        //连接数据库
        conn= DbUtil.getConnection();
//        //使用反射调用方法(invoke一行会出现空指针异常)
//        try {
//            Class c = Class.forName("com.bd.pigmanage.test.Test");
//            Object instance=c.newInstance();
//            Method declaredMethod = c.getDeclaredMethod(method, String.class);
//            declaredMethod.setAccessible(true);
//            declaredMethod.invoke(instance,sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //不使用反射
        if("insert".equals(method)){
            insert(sql);
        }
        if("delete".equals(method)){
            delete(sql);
        }
        if("update".equals(method)){
            update(sql);
        }
        if("select".equals(method)){
            select(sql);
        }
    }
    //单个插入
    private void insert(String sql){
        System.out.println("Dao层插入语句的SQL"+sql);
        //执行sql语句
        try {

            ps=conn.prepareStatement(sql);
            int flag=ps.executeUpdate();
            System.out.println("插入数据的条数："+flag);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //单个删除
    private void delete(String sql){

    }
    //单个修改
    private void update(String sql){

    }
    //查询
    private void select(String sql){

    }


}
