package com.bd.pigmanage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author AlwaysXu
 */
public class DbUtil {
        private static final String DRIVER="com.mysql.cj.jdbc.Driver";
        private static final String URL="jdbc:mysql://localhost:3306/pig_manager?useSSL=false&serverTimezone=UTC&characterEncording=utf-8";
        private static final String USERNAME="root";
        private static final String PASSWORD="123456";

    /**
     * 连接数据库
     * @return connnection 对象
     */
    public static Connection getConnection() {
            Connection conn=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            try {
                Class.forName(DRIVER);
                conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
                System.out.println("数据库连接成功");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return conn;
        }

    /**
     * 关闭数据库
     * @param conn
     * @param ps
     * @param rs
     */
        public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs) {
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
                // TODO: handle exception
            }

        }

    public static void main(String[] args) {
        Connection connection = getConnection();

    }
}
