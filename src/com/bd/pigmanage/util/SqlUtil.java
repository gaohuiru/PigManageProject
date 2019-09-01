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
    /**
     *  生成插入的sql语句
     * @param beans 从uri的视图名解析出的对应物理表名的类名，传入后通过maptobean函数成为一个bean对象
     * @param map 从前台获取一直传下来的数据
     * @return sql 由一条或多条sql语句组合成的sql语句
     * @throws Exception
     */
    public static String insertSQL(String[] beans, Map<String, List<Object>> map) throws Exception{
        //使用list存储SQL语句和对应的实例化Po对象(一般只有一条sql语句和一个Po对象)
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
                insertSQL.append("'"+valueList.get(i)+"'");
                if (i < len - 1)
                    insertSQL.append(",");
            }
            insertSQL.append(")");
            //            System.out.println(insertSQL.toString());
            sqls.add(insertSQL.toString());
        }
        //return sqls;
        //将生成的多条语句（一般只有一条）合并成一句sql语句
        StringBuffer sql=new StringBuffer();
        for(int i=0;i<sqls.size();i++){
            sql.append(sqls.get(i));
            if(i<sqls.size()-1){
                sql.append(";");
            }
        }
        return sql.toString();
    }
    /**
     *  生成修改的sql语句
     * @param beans 从uri的视图名解析出的对应物理表名的类名，传入后通过maptobean函数成为一个bean对象
     * @param map 从前台获取一直传下来的数据
     * @return sql 由一条或多条sql语句组合成的sql语句
     * @throws Exception
     */
    public static String updateSQL(String[] beans, Map<String, List<Object>> map) throws Exception{
        //使用list存储SQL语句和对应的实例化Po对象(一般只有一条sql语句和一个Po对象)
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

            StringBuffer updateSQL = new StringBuffer();
            updateSQL.append("update " + StyleUtil.humpToLine((clazz).getSimpleName()) + " set ");
            for (int i = 0, len = fieldsList.size(); i < len; i++)
            {
                updateSQL.append(StyleUtil.humpToLine(fieldsList.get(i)));
                updateSQL.append("=");
                updateSQL.append("'"+valueList.get(i)+"'");
                if (i < (len - 1))
                    updateSQL.append(",");
            }
            if(map.containsKey("where")){
                updateSQL.append(" where ");
                for (int i = 0, len = map.get("where").size(); i < len; i++)
                {
                    updateSQL.append(StyleUtil.humpToLine((String) map.get("where").get(i)));
                    if (i < len - 1)
                        updateSQL.append(" and ");
                }

            }
            //            System.out.println(insertSQL.toString());
            sqls.add(updateSQL.toString());
        }

        //将生成的多条语句（一般只有一条）合并成一句sql语句
        StringBuffer sql=new StringBuffer();
        for(int i=0;i<sqls.size();i++){
            sql.append(sqls.get(i));
            if(i<sqls.size()-1){
                sql.append(";");
            }
        }
        return sql.toString();

        // return sqls;




    }
    /**
     *  生成删除的sql语句
     * @param beans 从uri的视图名解析出的对应物理表名的类名，传入后通过maptobean函数成为一个bean对象
     * @param map 从前台获取一直传下来的数据
     * @return sql 由一条或多条sql语句组合成的sql语句
     * @throws Exception
     */
    public static String deleteSQL(String[] beans, Map<String, List<Object>> map) throws Exception{
        //使用list存储SQL语句和对应的实例化Po对象(一般只有一条sql语句和一个Po对象)
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

            StringBuffer deleteSQL = new StringBuffer();
            deleteSQL.append("delete from " + StyleUtil.humpToLine((clazz).getSimpleName()));
            for (int i = 0, len = fieldsList.size(); i < len; i++)
            {
                if(i==1){
                    deleteSQL.append(" where ");
                }
                deleteSQL.append(StyleUtil.humpToLine(fieldsList.get(i)));
                deleteSQL.append("=");
                deleteSQL.append("'"+valueList.get(i)+"'");
                if (i < (len - 1))
                    deleteSQL.append(" and ");
            }
            sqls.add(deleteSQL.toString());
        }
        //return sqls;
        //将生成的多条语句（一般只有一条）合并成一句sql语句
        StringBuffer sql=new StringBuffer();
        for(int i=0;i<sqls.size();i++){
            sql.append(sqls.get(i));
            if(i<sqls.size()-1){
                sql.append(";");
            }
        }
        return sql.toString();

    }
    /**
     *  生成查询的sql语句
     * @param beans 从uri的视图名解析出的对应物理表名的类名，传入后通过maptobean函数成为一个bean对象
     * @param map 从前台获取一直传下来的数据
     * @return sql 由一条或多条sql语句组合成的sql语句
     * @throws Exception
     */
    public static List<String> selectSQL(String[] beans, Map<String, List<Object>> map) throws Exception {
        //使用list存储SQL语句和对应的实例化Po对象(一般只有一条sql语句和一个Po对象)
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
                    selectSQL.append(StyleUtil.humpToLine(fieldsList.get(i)));
                    selectSQL.append("=");
                    selectSQL.append("'"+valueList.get(i)+"'");
                    if(i<fieldsList.size()-1){
                        selectSQL.append(" and ");
                    }

                }

            }
            //            System.out.println(insertSQL.toString());
            sqls.add(selectSQL.toString());
        }
        return sqls;
//        //将生成的多条语句（一般只有一条）合并成一句sql语句
//        StringBuffer sql=new StringBuffer();
//        for(int i=0;i<sqls.size();i++){
//            sql.append(sqls.get(i));
//            if(i<sqls.size()-1){
//                sql.append(";");
//            }
//        }
//        return sql.toString();
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
        String[] beans={"DiseaseJudgeSet","InInformation"};
        Map<String, List<Object>> map=new HashMap<>();
        List<Object> li1=new ArrayList<>();
        li1.add(123);
        List<Object> li2=new ArrayList<>();
        li2.add(100);
        List<Object> li3=new ArrayList<>();
        li3.add("pigVarietyId=1");


        map.put("growthStage",li1);
        map.put("pigStep",li2);
        map.put("where",li3);
//        String sql=deleteSQL(beans,map);
//        System.out.println(sql);
        List<String> sqls=selectSQL(beans,map);
        for(int i=0;i< sqls.size();i++){
            System.out.println("这是第"+i+"条查询语句： "+sqls.get(i));
        }
    }



}
