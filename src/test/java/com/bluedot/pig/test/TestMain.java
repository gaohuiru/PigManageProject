package com.bluedot.pig.test;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * @author xxbb
 */
public class TestMain {
    @Test
    public void longTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object obj=Class.forName("java.lang.Integer");

    }
    @Test
    public void reflectTest() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz=MyFly.class;
        Object obj=clazz.newInstance();
        Method method=clazz.getDeclaredMethod("fly", Map.class);
        method.setAccessible(true);
        method.invoke(obj,new HashMap<>());
    }
}
