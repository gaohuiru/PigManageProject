package com.bluedot.pig.test;

import java.sql.*;

public class DbUtil{
    //jdbc:mysql://139.9.141.135/db_pig?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/db_pig?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8";
    private static final String USERNAME="root";
    private static final String PASSWORD="123456";

    public static Connection getConnection() {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            Class.forName(DRIVER);
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return conn;
    }
    public static void closeAll(Connection conn, Statement ps, ResultSet rs) {
        try {
            if(rs!=null) {
                rs.close();
            }
            if(ps!=null) {
                ps.close();
            }
            if(conn!=null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}