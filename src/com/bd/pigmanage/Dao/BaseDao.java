package com.bd.pigmanage.Dao;

import com.bd.pigmanage.test.Test;
import com.bd.pigmanage.util.DbUtil;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    public BaseDao(){

    }
    public BaseDao(String sql){



        //分析sql语句，调用对应方法
        String method= sql.substring(0,6);

        //使用反射调用方法(单独测试时出现invoke的空指针异常，然后莫名其妙又不会了)
        try {
            Class c = Class.forName("com.bd.pigmanage.Dao.BaseDao");
            Object instance=c.newInstance();
            Method declaredMethod = c.getDeclaredMethod(method, String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(instance,sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //不使用反射
//        if("insert".equals(method)){
//            insert(sql);
//        }
//        if("delete".equals(method)){
//            delete(sql);
//        }
//        if("update".equals(method)){
//            update(sql);
//        }
//        if("select".equals(method)){
//            select(sql);
//        }

    }
    //单个插入
    private void insert(String sql){
        System.out.println("Dao层插入语句的SQL"+sql);
        //执行sql语句
        try {
            //连接数据库
            conn= DbUtil.getConnection();
            //
            ps=conn.prepareStatement(sql);
            int num=ps.executeUpdate();
            System.out.println("数据库插入数据条数："+num);
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
    public static void main(String[] args){
        String sql="insert into disease_judge_set (pig_variety_id,growth_stage,temperature,food_intake,pig_step) values(1,4,22.0,11.0,0)";
        BaseDao ts=new BaseDao(sql);
    }



}
