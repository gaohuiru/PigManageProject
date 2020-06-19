package com.bluedot.pig.mapper;

import com.bluedot.pig.util.DbUtil;
import com.bluedot.pig.util.PoUtil;
import com.bluedot.pig.util.StyleUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AlwaysXu
 */
public class BaseDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public BaseDao() {

    }

    public BaseDao(String sql, Map<String, List<Object>> reqMap) {


        //分析sql语句，调用对应方法 insert delete update select 刚好都是6个字母
        String method = sql.substring(0, 6);

        //使用反射调用方法(单独测试时出现invoke的空指针异常，然后莫名其妙又不会了)
        try {
            Class c = Class.forName("com.bluedot.pig.mapper.BaseDao");
            Object instance = c.newInstance();
            Method declaredMethod = c.getDeclaredMethod(method, String.class, Map.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(instance, sql, reqMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //不使用反射
//        if("insert".equals(method)){
//            insert(sql);
//        }
//        if("delete".equals(method)){
//            delete(sql);
//        }
//        if("update".equals(method)){
//            update(sql);
//        }
//        if("select".equals(method)){
//            select(sql);
//        }

    }

    /**
     * 插入功能
     * @param sql 传入的sql语句
     * @param reqMap 主要用于存放执行结果(插入成功/插入失败)
     */
    private void insert(String sql, Map<String, List<Object>> reqMap) {
        System.out.println("Dao层插入语句的SQL： " + sql);
        //执行sql语句
        try {
            //连接数据库
            conn = DbUtil.getConnection();
            //
            ps = conn.prepareStatement(sql);
            int num = ps.executeUpdate();
            System.out.println("数据库插入数据条数：" + num);
            if (num != 0) {
                //清空map
                reqMap.clear();
                List<Object> temp=new ArrayList<>();
                temp.add("插入成功");
                reqMap.put("result",temp);
            } else {
                System.out.println("数据插入失败");
                List<Object> temp=new ArrayList<>();
                temp.add("插入失败");
                reqMap.put("result",temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeAll(conn, ps, rs);
        }


    }

    /**
     * 删除功能
     * @param sql 传入的sql语句
     * @param reqMap 主要用于存放执行结果(删除成功/删除失败)
     */
    private void delete(String sql, Map<String, List<Object>> reqMap) {
        System.out.println("Dao层删除的SQL： " + sql);
        //执行sql语句
        try {
            //连接数据库
            conn = DbUtil.getConnection();
            //
            ps = conn.prepareStatement(sql);
            int i = ps.executeUpdate();
            System.out.println("数据库删除数据条数：" + i);
            if (i!=0) {
                //清空map
                reqMap.clear();
                List<Object> temp=new ArrayList<>();
                temp.add("删除成功");
                reqMap.put("result",temp);
            } else {
                System.out.println("数据删除失败");
                List<Object> temp=new ArrayList<>();
                temp.add("删除失败");
                reqMap.put("result",temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeAll(conn, ps, rs);
        }



    }

    /**
     * 修改功能
     * @param sql 传入的sql语句
     * @param reqMap 主要用于存放执行结果（修改成功/修改失败）
     */
    private void update(String sql, Map<String, List<Object>> reqMap) {
        System.out.println("Dao层修改的SQL： " + sql);
        //执行sql语句
        try {
            //连接数据库
            conn = DbUtil.getConnection();
            //
            ps = conn.prepareStatement(sql);
            int i = ps.executeUpdate();
            System.out.println("数据库修改数据条数：" + i);
            if (i!=0) {
                //清空map
                reqMap.clear();
                List<Object> temp=new ArrayList<>();
                temp.add("修改成功");
                reqMap.put("result",temp);
            } else {
                System.out.println("数据修改失败");
                List<Object> temp=new ArrayList<>();
                temp.add("修改失败");
                reqMap.put("result",temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeAll(conn, ps, rs);
        }



    }

    /**
     * 查询功能，目前只支持查询记录的所有属性，即(select *)
     * @param sql 传入的sql语句
     * @param reqMap 主要用于存放执行的结果（Po类对象和查询成功/查询失败）
     */
    private void select(String sql, Map<String, List<Object>> reqMap) {
        System.out.println("Dao层查询语句的SQL： " + sql);

        try {
            //执行sql语句
            conn = DbUtil.getConnection();
            //
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Object> objectList = new ArrayList<>();
            //实例化查询对象
            //获取sql语句中包含的类名
            String className = PoUtil.getClassName(sql);
            System.out.println("解析得出的SQL语句中的Po类： "+className);

            //先将对象加载至类对象阶段
            Class clazz = Class.forName("com.bd.pigmanage.Po."+className);
            while (rs.next()) {
                //实例化
                Object PoObject = clazz.newInstance();
                //获取对象的属性
                Field[] fields = clazz.getDeclaredFields();

                for(Field field:fields){
                    field.setAccessible(true);

                    //根据Po类的属性类型来选择不同的数据获取方式，目前我们Po类就设定 String Double Ingeter三种类型
                    if("class java.lang.Integer".equals(field.getType().toString())) {
                        field.set(PoObject, rs.getInt(StyleUtil.humpToLine(field.getName())));
                    }
                    if("class java.lang.Double".equals(field.getType().toString())) {
                        field.set(PoObject, rs.getDouble(StyleUtil.humpToLine(field.getName())));
                    }
                    if("class java.lang.String".equals(field.getType().toString())) {
                        field.set(PoObject, rs.getString(StyleUtil.humpToLine(field.getName())));
                    }
                }
                //赋值好的Po对象存入List数组中
                objectList.add(PoObject);
            }
            //将List数组存入Map中
            reqMap.put(className,objectList);
            System.out.println("查询完成");
            List<Object> temp=new ArrayList<>();
            temp.add("查询成功");
            reqMap.put("result",temp);

        } catch (Exception e) {
            List<Object> temp=new ArrayList<>();
            temp.add("查询出错");
            reqMap.put("result",temp);
            e.printStackTrace();
        }finally {
            DbUtil.closeAll(conn,ps,rs);
        }

    }

    public static void main(String[] args) {

        Map<String,List<Object>> reqMap=new HashMap<>();

        String dsql="delete from disease_judge_set where pig_Variety_id=1";
        BaseDao baseDao2=new BaseDao(dsql,reqMap);
        String usql="update disease_judge_set set pig_step=111 where pig_Variety_id=6 ";
        BaseDao baseDao3=new BaseDao(usql,reqMap);
        String isql="insert into disease_judge_set (pig_variety_id,growth_stage,temperature,food_intake,pig_step) values('9','123','100','37.6','12')";
        BaseDao ibd=new BaseDao(isql,reqMap);
        String sql="select * from disease_judge_set";
        BaseDao bd=new BaseDao(sql,reqMap);
        if(reqMap.containsKey("DiseaseJudgeSet")) {
            System.out.println("成功咧！！！");
            List<Object> lists = reqMap.get("DiseaseJudgeSet");
            System.out.println("查询到的数据的条数： "+lists.size());
            for(Object ob:lists){
                System.out.println(ob.toString());
            }

        }

    }


}
