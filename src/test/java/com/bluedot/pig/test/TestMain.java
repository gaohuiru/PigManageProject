package com.bluedot.pig.test;

import com.bluedot.pig.util.TimeUtil;
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
    public void stringTest(){
        String str="wwww";
        StringBuilder sb=new StringBuilder("zzz");
        addString(str,sb);
        System.out.println(str+"     "+sb.toString());
    }
    private void addString(String str,StringBuilder sb){
        str=str+"qqq";
        sb.append("qqq");
    }
    @Test
    public void longTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object obj=Class.forName("java.lang.Integer");

        System.out.println(TimeUtil.getDate());
        System.out.println(TimeUtil.getDateTime());
        System.out.println(TimeUtil.getTime());
        String str="6.0";
        //System.out.println(Integer.parseInt(str));
        System.out.println(Integer.valueOf(str));

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
