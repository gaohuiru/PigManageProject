package com.bd.pigmanage.service;

import com.bd.pigmanage.util.PropertiesUtil;
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

    public PigService(String method, String table, Map<String, List<Object>> reqMap) {
        System.out.println("具体service获取到的方法："+method);

        try {

            //获取视图表对应的物理表
            String[] dataTables = TableUtil.getTables(table);
            System.out.println("所需的物理表：");
            for(String s:dataTables){
                System.out.println(s);
            }

            //通过反射实例化类
            Class c = Class.forName("com.bd.pigmanage.service.PigService");
            Object instance = c.newInstance();

            //通过反射调用对应方法
            Method declaredMethod = c.getDeclaredMethod(method, String[].class, Map.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(instance, dataTables, reqMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insert(String[] tables, Map<String, List<Object>> reqMap) {
        System.out.println("service:");
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
