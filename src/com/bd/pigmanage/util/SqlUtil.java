package com.bd.pigmanage.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将传入对象生成sql语句
 * @author xcj AlwaysXu binbinbin666
 */
public class SqlUtil {
    //用bean对象拼成sql语句 insert 插入语句
    public static List<String> insertSQL(String[] beans, Map<String, List<Object>> map) throws Exception {

        List<String> sqls = new ArrayList<>();
        //返回实例化对象
        List<Object> objects = mapToBean(beans, map);
        for (Object object : objects)
        {
            //遍历每一个objects，每次遍历名为object
            Class clazz = object.getClass();
            //获取全部字段，形成fields[]
            Field[] fields = clazz.getDeclaredFields();
            List<String> fieldsList = new ArrayList<>();
            List<Object> valueList = new ArrayList<>();
            for (Field field : fields)
            {
                //遍历全部字段数组，每个字段名字为field
                field.setAccessible(true);
                if (field.get(object) != null)
                {
                    fieldsList.add(field.getName());
                    valueList.add(field.get(object));
                    //                    System.out.println(field.getName() + " " + field.get(object));

                }

            }

            StringBuffer insertSQL = new StringBuffer();
            insertSQL.append("insert into " + StyleUtil.humpToLine((clazz).getSimpleName()) + " (");
            for (int i = 0, len = fieldsList.size(); i < len; i++)
            {
                insertSQL.append(StyleUtil.humpToLine(fieldsList.get(i)));
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

    public static List<String> updateSQL(String[] beans, Map<String, List<Object>> map) throws Exception{




        return null;
    }
    public static List<String> deleteSQL(String[] beans, Map<String, List<Object>> map) throws Exception{




        return null;
    }

    public static List<String> selectSQL(String[] beans, Map<String, List<Object>> map) throws Exception {
        List<String> sqls = new ArrayList<>();
        //返回实例化对象
        List<Object> objects = mapToBean(beans, map);
        for (Object object : objects)
        {
            //遍历每一个objects，每次遍历名为object
            Class clazz = object.getClass();
            //获取全部字段，形成fields[]
            Field[] fields = clazz.getDeclaredFields();
            List<String> fieldsList = new ArrayList<>();
            List<Object> valueList = new ArrayList<>();
            for (Field field : fields)
            {
                //遍历全部字段数组，每个字段名字为field
                field.setAccessible(true);
                //bean对象内属性的值如果为空则不会添加到list里
                if (field.get(object) != null)
                {
                    fieldsList.add(field.getName());
                    valueList.add(field.get(object));
                    //                    System.out.println(field.getName() + " " + field.get(object));

                }

            }
            StringBuffer selectSQL = new StringBuffer();
            selectSQL.append("select * from " + StyleUtil.humpToLine((clazz).getSimpleName()));
            if (fieldsList.size() != 0){
                selectSQL.append(" where ");
                for(int i=0;i<fieldsList.size();i++){
                    if(i!=0){
                        selectSQL.append(" and ");
                    }
                    selectSQL.append(StyleUtil.humpToLine(fieldsList.get(i)));
                    selectSQL.append(" = ");
                    selectSQL.append(valueList.get(i));

                }

            }
            //            System.out.println(insertSQL.toString());
            sqls.add(selectSQL.toString());
        }
        return sqls;
    }
    /**
     * 创建bean对象将map中的数据传入
     * @param beans 对象的名字
     * @param map 对象的数据
     * @return 转化成bean对象
     * @throws Exception
     */
    private static List<Object> mapToBean(String[] beans, Map<String, List<Object>> map) throws Exception {
        List<Object> list = new ArrayList<>();
        for (String bean : beans)
        {
            Class clazz = Class.forName("com.bd.pigmanage.Po." + bean);
            Constructor constructor = clazz.getConstructor(Map.class);
            Object object = constructor.newInstance(map);
            list.add(object);
        }
        return list;

    }

    public static void main(String[] args) throws Exception {
        String[] beans={"DiseaseJudgeSet"};
        Map<String, List<Object>> map=new HashMap<>();
        List<Object> li1=new ArrayList<>();
        li1.add(123);
        List<Object> li2=new ArrayList<>();
        li2.add(100);
        map.put("pigVarietyId",li1);
        map.put("pigStep",li2);
        List<String> sqlList=insertSQL(beans,map);
        System.out.println(sqlList.get(0));

    }



}
