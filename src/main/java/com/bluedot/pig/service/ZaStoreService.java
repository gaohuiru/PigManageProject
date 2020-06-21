package com.bluedot.pig.service;

import com.bluedot.pig.mapper.BaseDao;
import com.bluedot.pig.util.SqlUtil;
import com.bluedot.pig.util.TableUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZaStoreService {
    public ZaStoreService(){

    }

    public ZaStoreService(String method, String viewObjectName, Map<String, List<Object>> reqMap){
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
            Class c = Class.forName("com.bluedot.pig.service.ZaStoreService");
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


    private void insert(String viewObjectName, Map<String, List<Object>> reqMap) throws Exception {
        System.out.println("正在使用插入方法");
        //将前台传入的视图表对象名转换成对应的一个或多个物理表名
        String[] beans= TableUtil.getTables(viewObjectName);
        //生成SQL语句
        //创建接收Sql语句的字符串数组
        String[] sqls=null;
        //获取sql语句的List集合(一般只有一条sql语句)
        String sql= SqlUtil.insertSQL(beans, reqMap);
        System.out.println("pigservice生成的SQL语句: "+sql);
        //遍历List生成sql语句并调用dao层处理数据
        BaseDao bd=new BaseDao(sql,reqMap);

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
}
