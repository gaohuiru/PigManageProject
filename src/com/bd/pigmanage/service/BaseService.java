package com.bd.pigmanage.service;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;

public class BaseService {
    public BaseService(String uri, Map<String, List<Object>> reqMap) {
        //解析URi
        String[] split = uri.split("/");
        String className = split[1];
        String methodName = split[2].substring(0,split[2].indexOf("."));
        System.out.println(className+"  "+methodName);

        try {
            Class<?> c = Class.forName("com.bd.pigmanage.service."+className);
            Constructor constructor = c.getConstructor(String.class,Map.class);
            constructor.newInstance(methodName,reqMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
