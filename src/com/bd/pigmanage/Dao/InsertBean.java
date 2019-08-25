package com.bd.pigmanage.Dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertBean
{
//    @org.junit.Test
    //用bean对象拼成sql语句
    private static List<String> returnSQL(String[] beans, Map<String, Object> map) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException
    {

        List<String> sqls = new ArrayList<>();
        List<Object> objects = mapToBean(beans, map);
        for (Object object : objects)
        {
            Class clazz = object.getClass();

            Field[] fields = clazz.getDeclaredFields();
            List<String> fieldsList = new ArrayList<>();
            List<Object> valueList = new ArrayList<>();
            for (Field field : fields)
            {
                field.setAccessible(true);
                if (field.get(object) != null)
                {
                    fieldsList.add(field.getName());
                    valueList.add(field.get(object));
                    //                    System.out.println(field.getName() + " " + field.get(object));

                }

            }

            StringBuffer insertSQL = new StringBuffer();
            insertSQL.append("insert into " + (clazz).getSimpleName() + " (");
            for (int i = 0, len = fieldsList.size(); i < len; i++)
            {
                insertSQL.append(fieldsList.get(i));
                if (i < (len - 1))
                    insertSQL.append(",");
            }
            insertSQL.append(") values(");
            for (int i = 0, len = valueList.size(); i < len; i++)
            {
                insertSQL.append(valueList.get(i));
                if (i < len - 1)
                    insertSQL.append(",");
            }
            insertSQL.append(")");
            //            System.out.println(insertSQL.toString());
            sqls.add(insertSQL.toString());
        }
        return sqls;
    }

//    @org.junit.Test

    /**
     *
     * @param beans 对象的名字
     * @param map 对象的数据
     * @return 转化成bean对象
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    private static List<Object> mapToBean(String[] beans, Map<String, Object> map) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException
    {
        List<Object> list = new ArrayList<>();
        for (String bean : beans)
        {
            Class clazz = Class.forName("com.bd.pigmanage.Vo." + bean);

            Constructor constructor = clazz.getConstructor(Map.class);
            Object object = constructor.newInstance(map);
            list.add(object);
        }
        return list;

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
        //参数  前端传递得操作对象
        String[] beans = {"User", "Student"};
        //参数  前端传递得数据
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "miku");
        map.put("sex", "man");
        map.put("age", 18);

        //返回得sql语句
        List<String> sqls = returnSQL(beans, map);


        for (String sql : sqls)
            System.out.println("sql:" + sql);
    }


}
