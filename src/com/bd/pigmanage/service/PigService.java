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

/**
 * @author  AlwaysXu
 */
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

            //通过反射找到对应方法
            Method declaredMethod = c.getDeclaredMethod(method, String.class, Map.class);
            declaredMethod.setAccessible(true);
            //调用方法
            declaredMethod.invoke(instance,viewObjectName, reqMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加数据
     * @param viewObjectName 对应视图表
     * @param reqMap          前台传来的数据
     * @throws Exception
     */
    private void insert(String viewObjectName, Map<String, List<Object>> reqMap) throws Exception {
        System.out.println("正在使用插入方法");
        //将前台传入的视图表对象名转换成对应的一个或多个物理表名
        String[] beans=TableUtil.getTables(viewObjectName);
        //生成SQL语句
        //获取sql语句的List集合(一般只有一条sql语句)
        List<String> sqlList=SqlUtil.insertSQL(beans, reqMap);
        System.out.println("pigservice生成SQL语句的条数： "+sqlList.size());
        System.out.println("pigservice生成的SQL语句: "+sqlList.get(0));
        //遍历List生成sql语句并调用dao层处理数据
        BaseDao bd=null;
        for(int i=0;i<sqlList.size();i++){
            //接收SQL语句=sqlList.get(i);
            //调用DAO层处理命令
            bd=new BaseDao(sqlList.get(i),reqMap);
        }
        if(reqMap.isEmpty()){
            List<Object> list = new ArrayList<>();
            list.add("成功");
            reqMap.put("result", list);
            System.out.println("pigService的插入反馈结果: "+reqMap.get("result").get(0));

        }else{
            List<Object> list = new ArrayList<>();
            list.add("失败");
            reqMap.put("result", list);
            for (Map.Entry<String, List<Object>> entry : reqMap.entrySet()) {
                String mapKey = entry.getKey();
                List<Object> value = entry.getValue();
                for (Object v : value) {
                    if("result".equals(mapKey)){
                        System.out.println("PigService插入反馈结果： "+v);
                        System.out.println("--------------------------");
                    }
                    System.out.println(mapKey + ":" + v.toString());

                }
            }

        }
    }

    /**
     * 删除数据
     * @param viewObjectName 对应视图表
     * @param reqMap          前台传来的数据
     */
    private void delete(String viewObjectName, Map<String, List<Object>> reqMap){

    }

    /**
     * 修改数据
     * @param viewObjectName 对应视图表
     * @param reqMap          前台传来的数据
     */
    private void update(String viewObjectName, Map<String, List<Object>> reqMap){

    }

    /**
     * 查询数据
     * @param viewObjectName 对应视图表
     * @param reqMap          前台传来的数据
     */
    private void select(String viewObjectName, Map<String, List<Object>> reqMap) throws Exception {
        System.out.println("正在使用查询方法");
        //将前台传入的视图表对象名转换成对应的一个或多个物理表名
        String[] beans=TableUtil.getTables(viewObjectName);
        //生成SQL语句
        //获取sql语句的List集合(一般只有一条sql语句)
        List<String> sqlList=SqlUtil.selectSQL(beans, reqMap);
        System.out.println("pigservice生成SQL语句的条数： "+sqlList.size());
        System.out.println("pigservice生成的SQL语句: "+sqlList.get(0));
        reqMap.clear();
        List<Object> list = new ArrayList<>();
        list.add("成功");
        reqMap.put("result", list);
        System.out.println("pigService的查询反馈结果: "+reqMap.get("result").get(0));
    }
}
