package com.bluedot.pig.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xxbb
 */
public class MyFly {
    private void fly(Map<String,Object> map){
        System.out.println("开始反射");
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz=MyFly.class;
        Object obj=clazz.newInstance();
        Method method=clazz.getDeclaredMethod("fly", Map.class);
        method.setAccessible(true);
        method.invoke(obj,new HashMap<>());
    }
}
