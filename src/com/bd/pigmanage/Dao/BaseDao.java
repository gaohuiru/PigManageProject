package com.bd.pigmanage.Dao;

import com.bd.pigmanage.util.DbUtil;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * @author AlwaysXu
 */
public class BaseDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    public BaseDao(){

    }
    public BaseDao(String sql, Map<String, List<Object>> reqMap){



        //分析sql语句，调用对应方法 insert delete update select 刚好都是6个字母
        String method= sql.substring(0,6);

        //使用反射调用方法(单独测试时出现invoke的空指针异常，然后莫名其妙又不会了)
        try {
            Class c = Class.forName("com.bd.pigmanage.Dao.BaseDao");
            Object instance=c.newInstance();
            Method declaredMethod = c.getDeclaredMethod(method, String.class,Map.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(instance,sql,reqMap);
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
    private void insert(String sql,Map<String, List<Object>> reqMap){
        System.out.println("Dao层插入语句的SQL： "+sql);
        //执行sql语句
        try {
            //连接数据库
            conn= DbUtil.getConnection();
            //
            ps=conn.prepareStatement(sql);
            int num=ps.executeUpdate();
            System.out.println("数据库插入数据条数："+num);
            if(num!=0) {
                //清空map
                reqMap.clear();
            }
            else{
                System.out.println("数据插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //单个删除
    private void delete(String sql,Map<String, List<Object>> reqMap){

    }
    //单个修改
    private void update(String sql,Map<String, List<Object>> reqMap){

    }
    //查询
    private void select(String sql,Map<String, List<Object>> reqMap){

    }



}
