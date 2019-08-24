package com.bd.pigmanage.Dao;



import javax.xml.crypto.dsig.keyinfo.PGPData;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class PigDao {
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rsList=null;
    private ResultSetMetaData rsdata=null;
    private int rsInt=0;


    PigDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/pig_manager?useSSL=false&serverTimezone=UTC&characterEncording=utf-8","root","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select(String sql, Map<String, List<Object>> map){
        try {
            map.clear();
            String ColumnName=null;
            List<Object> DataList=null;
            int ColumnNumber=1;
            ps=conn.prepareStatement(sql);
            rsList= ps.executeQuery();
            rsdata=rsList.getMetaData();
            while(rsList.next()){
                for(int j=1;j<=rsdata.getColumnCount();j++) {
                    ColumnName = rsdata.getColumnName(j);
                    DataList.add(rsList.getString(j));
                    map.put(ColumnName, DataList);
                }
                DataList.clear();
                ColumnNumber++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String sql, Map<String, List<Object>> map){
        try {
            String ColumnName=null;
            List<Object> DataList=null;
            int ColumnNumber=1;
            ps=conn.prepareStatement(sql);
            rsInt= ps.executeUpdate();
            if(rsInt!=0){
                DataList.add("1");
                map.put("result",DataList);
            }else{
                DataList.add("0");
                map.put("result",DataList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String sql, Map<String, List<Object>> map){
        try {
            map.clear();
            String ColumnName=null;
            List<Object> DataList=null;
            int ColumnNumber=1;
            ps=conn.prepareStatement(sql);
            rsInt= ps.executeUpdate();
            if(rsInt!=0){
                DataList.add("1");
                map.put("result",DataList);
            }else{
                DataList.add("0");
                map.put("result",DataList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String sql, Map<String, List<Object>> map){
        try {
            map.clear();
            String ColumnName=null;
            List<Object> DataList=null;
            int ColumnNumber=1;
            ps=conn.prepareStatement(sql);
            rsInt= ps.executeUpdate();
            if(rsInt!=0){
                DataList.add("1");
                map.put("result",DataList);
            }else{
                DataList.add("0");
                map.put("result",DataList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PigDao pg=new PigDao();
    }

}
