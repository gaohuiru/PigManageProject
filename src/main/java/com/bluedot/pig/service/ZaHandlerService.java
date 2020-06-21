package com.bluedot.pig.service;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;

/**
 * @author chb
 */
public class ZaHandlerService {
    public ZaHandlerService(String uri, Map<String, List<Object>> reqMap) {
        //解析URi
        String[] split = uri.split("/");
        String className = split[1];
        String methodName = split[2];
        String viewTable=split[3].substring(0,split[3].indexOf("."));
        System.out.println("类名："+className+" 方法名："+methodName+" 视图表名/View对象名："+viewTable);

        try {
            Class<?> c = Class.forName("com.bd.pigmanage.service."+className);
            //获取类中的特定的构造方法
            Constructor constructor = c.getConstructor(String.class,String.class,Map.class);
            //调用了有参构造方法
            constructor.newInstance(methodName,viewTable,reqMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
