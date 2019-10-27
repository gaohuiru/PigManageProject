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
        String sql=SqlUtil.insertSQL(beans, reqMap);
        System.out.println("pigservice生成的SQL语句: "+sql);
        //遍历List生成sql语句并调用dao层处理数据
        BaseDao bd=new BaseDao(sql,reqMap);

//        if(reqMap.isEmpty()){
//            List<Object> list = new ArrayList<>();
//            list.add("成功");
//            reqMap.put("result", list);
//            System.out.println("pigService的插入反馈结果: "+reqMap.get("result").get(0));
//
//        }else{
//            List<Object> list = new ArrayList<>();
//            list.add("失败");
//            reqMap.put("result", list);
//            for (Map.Entry<String, List<Object>> entry : reqMap.entrySet()) {
//                String mapKey = entry.getKey();
//                List<Object> value = entry.getValue();
//                for (Object v : value) {
//                    if("result".equals(mapKey)){
//                        System.out.println("PigService插入反馈结果： "+v);
//                        System.out.println("--------------------------");
//                    }
//                    System.out.println(mapKey + ":" + v.toString());
//
//                }
//            }
//
//        }
        System.out.println("pigService的插入反馈结果: "+reqMap.get("result").get(0));
    }

    /**
     * 删除数据
     * @param viewObjectName 对应视图表
     * @param reqMap          前台传来的数据
     */
    private void delete(String viewObjectName, Map<String, List<Object>> reqMap) throws Exception {
        System.out.println("正在使用删除方法");
        //将前台传入的视图表对象名转换成对应的一个或多个物理表名
        String[] beans=TableUtil.getTables(viewObjectName);
        //生成SQL语句
        //获取sql语句的List集合(一般只有一条sql语句)
        String sql=SqlUtil.deleteSQL(beans, reqMap);
        System.out.println("pigservice生成的SQL语句: "+sql);
        //遍历List生成sql语句并调用dao层处理数据
        BaseDao bd=new BaseDao(sql,reqMap);
        System.out.println("pigService的插入反馈结果: "+reqMap.get("result").get(0));
    }

    /**
     * 修改数据
     * @param viewObjectName 对应视图表
     * @param reqMap          前台传来的数据
     */
    private void update(String viewObjectName, Map<String, List<Object>> reqMap) throws Exception{
        System.out.println("正在使用删除方法");
        //将前台传入的视图表对象名转换成对应的一个或多个物理表名
        String[] beans=TableUtil.getTables(viewObjectName);
        //生成SQL语句
        //获取sql语句的List集合(一般只有一条sql语句)
        String sql=SqlUtil.updateSQL(beans, reqMap);
        System.out.println("pigservice生成的SQL语句: "+sql);
        //遍历List生成sql语句并调用dao层处理数据
        BaseDao bd=new BaseDao(sql,reqMap);
        System.out.println("pigService的更新反馈结果: "+reqMap.get("result").get(0));
    }

    /**
     * 查询数据
     * @param viewObjectName 对应视图表
     * @param reqMap          前台传来的数据
     */
    private void select(String viewObjectName, Map<String, List<Object>> reqMap) throws Exception {
        System.out.println("正在使用查询方法,查询对象："+viewObjectName);
        //将前台传入的视图表对象名转换成对应的一个或多个物理表名(即对应的Po类的类名)
        String[] beans=TableUtil.getTables(viewObjectName);
        //生成SQL语句
        //获取sql语句的List集合(一般只有一条sql语句)
        List<String> sqlList=SqlUtil.selectSQL(beans, reqMap);
        //
        System.out.println("pigservice生成的SQL语句条数: "+sqlList.size());
        BaseDao bd=null;
        for(int i=0;i<sqlList.size();i++){
            bd=new BaseDao(sqlList.get(i),reqMap);
            System.out.println("pigservice生成的SQL语句: "+ sqlList.get(i));
        }


        if("查询成功".equals(reqMap.get("result").get(0))) {
            System.out.println("pigService的查询反馈结果: "+reqMap.get("result").get(0));
            List<Object> lists=new ArrayList<Object>();
            //获取map中可能存在的对象名，一般是单表查询map中只存放一个对象的数据
            System.out.println("Map中存在的对象有：");
            for(String str:beans){
                lists.add(reqMap.get(str));
                System.out.println(str);
            }
            System.out.println("PigService层获取的结果：");
            for(Object obj:lists){
                System.out.println(obj.toString());
            }


        }else{
            //查询失败
            System.out.println("pigService的查询反馈结果: "+reqMap.get("result").get(0));

        }


    }
}
