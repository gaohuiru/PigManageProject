package com.bd.pigmanage.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PigService {

    public PigService() {
    }
    public PigService(String method, Map<String, List<Object>> reqMap) {
        System.out.println(method);

        try {
            Class c = Class.forName("com.bd.pigmanage.service.PigService");
            Object instance = c.newInstance();
            Method declaredMethod = c.getDeclaredMethod(method, Map.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(instance,reqMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertIllnessSet(Map<String, List<Object>> reqMap){
            System.out.println("service:");
        for (Map.Entry<String, List<Object>> entry:reqMap.entrySet()) {
            String mapKey = entry.getKey();
            List<Object> value = entry.getValue();
            for(Object v:value) {
                System.out.println(mapKey+":"+v.toString());
            }
        }
        //返回结果
        List<Object> list = new ArrayList<>();
        list.add("成功");
        reqMap.clear();
        reqMap.put("result",list);
    }
}
