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
        System.out.println("SqlUtil生成的语句："+sql);
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
            /**
             * 要生成where后面的字段逻辑比较复杂自己去悟，
             */
            //1.判断map里是否有where
            if(map.containsKey("where")){
                //2.1设置一个用来只生成一个where的标记
                boolean flag=true;
                //2.2一个计算作为删除条件个数的Count
                int count=0;
                //2.3一个计算作为语句中and个数的andCount
                int andCount=0;
                //3.计算条件个数
                for(int i=0,len1=map.get("where").size();i<len1;i++){
                    for(int j=0,len2=fieldsList.size();j<len2;j++){
                        //4.当存在对应值时则开始生成where后面的条件
                        if(map.get("where").get(i).equals(fieldsList.get(j))){
                            count++;
                        }
                        }
                    }
                //4.比较map中where的值（即做where条件的属性名）是否存在于filedsList中
                for(int i=0,len1=map.get("where").size();i<len1;i++){
                    for(int j=0,len2=fieldsList.size();j<len2;j++){
                        //5.当存在对应值时则开始生成where后面的条件
                        if(map.get("where").get(i).equals(fieldsList.get(j))){
                            if(flag){
                                updateSQL.append(" where ");
                                flag=false;
                            }
                            andCount++;
                            updateSQL.append(StyleUtil.humpToLine(fieldsList.get(j)));
                            updateSQL.append("=");
                            updateSQL.append("'"+valueList.get(j)+"'");
                            //and个数需要比条件个数少一个
                            if(andCount < count){
                                updateSQL.append(" and ");
                            }

                        }
                    }
                }
            }

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
        System.out.println("SqlUtil生成的语句："+sql);
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
    /**
     *假设前端发送一次请求中包含两个对象，例如PigInfo 和 PigVariety,，传递到map中的kv对是{pigNo，1001}，{pigVarietyid，1}
     * 我本想pigNo作为PigInfo生成语句的删除条件，pigvarietyid作为PigVariety的删除条件
     * 期望生成 delete from pig_info where pig_no=1001;
     *          delete from pig_variety where pig_variety_id=1
     * 但是这两类中都有pigvarietyid这个属性
     * 那么他们两个在实例化时都会从map中拿取pigVariety属性的值，用于生成删除语句
     * 实际上删除语句会是：delete from pig_info where pig_no=1001 and pigVarietyId=1;
     *                     delete from pig_variety where pig_variety_id=1;
     * 虽然这种情况一般不会出现，但需要大家注意
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
                if(i==0){
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
        System.out.println("SqlUtil生成的语句："+sql);
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
            sqls.add(selectSQL.toString());

        }
        System.out.println("SqlUtil生成的语句数："+sqls.size());
        for(String str:sqls){
            System.out.println(str);
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
