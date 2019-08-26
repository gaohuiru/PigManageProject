package com.bd.pigmanage.service;

import com.bd.pigmanage.Dao.BaseDao;
import com.bd.pigmanage.util.PropertiesUtil;
import com.bd.pigmanage.util.SqlUtil;
import com.bd.pigmanage.util.TableUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PigService {

    public PigService() {
    }

    public PigService(String method, String viewObjectName, Map<String, List<Object>> reqMap) {
        System.out.println("具体service获取到的方法："+method);

        try {
//            //暂时无用
//            //获取视图表对应的物理表
//            String[] dataTables = TableUtil.getTables(object);
//            System.out.println("所需的物理表：");
//            for(String s:dataTables){
//                System.out.println(s);
//            }

            //通过反射实例化类
            Class c = Class.forName("com.bd.pigmanage.service.PigService");
            Object instance = c.newInstance();

            //通过反射调用对应方法
            Method declaredMethod = c.getDeclaredMethod(method, String.class, Map.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(instance,viewObjectName, reqMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insert(String viewObjectName, Map<String, List<Object>> reqMap) throws Exception {
        System.out.println("service:");
        //将前台传入的视图表对象名转换成对应的一个或多个物理表名
        String[] beans=TableUtil.getTables(viewObjectName);
        //生成SQL语句
            //创建接收Sql语句的字符串数组
        String[] sqls=null;
            //获取sql语句的List集合(一般只有一条sql语句)
        List<String> sqlList=SqlUtil.insertSQL(beans, reqMap);
        System.out.println(sqlList.size());
        System.out.println("pigservice生成SQL语句的条数："+sqlList.get(0));
        //遍历List生成sql语句并调用dao层处理数据
        BaseDao bd=null;
        for(int i=0;i<sqlList.size();i++){
            //接收SQL语句=sqlList.get(i);
            //调用DAO层处理命令
            bd=new BaseDao(sqlList.get(i));


        }

        //dao
        //返回map数据


        for (Map.Entry<String, List<Object>> entry : reqMap.entrySet()) {
            String mapKey = entry.getKey();
            List<Object> value = entry.getValue();
            for (Object v : value) {
                System.out.println(mapKey + ":" + v.toString());
            }
        }
        //返回结果
        List<Object> list = new ArrayList<>();
        list.add("成功");
        reqMap.clear();
        reqMap.put("result", list);
    }
}
