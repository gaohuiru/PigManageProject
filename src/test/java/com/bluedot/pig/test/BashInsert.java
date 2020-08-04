package com.bluedot.pig.test;

import com.bluedot.pig.util.TimeUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author xxbb
 */
public class BashInsert {

    /**
     * 添加猪只信息
     */
    private void insertPigInfo() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        String str;
        str = TimeUtil.getDate();
        System.out.println(str);
        conn = DbUtil.getConnection();
        try {
            // 设置为手动提交
            conn.setAutoCommit(false);
            stat = conn.createStatement();
            long start = System.currentTimeMillis();

            String id = "190110000";
            int i = 0;
            for (i = 12; i < 42; i++) {
                if (i >= 10 && i < 100) {
                    id = "19011000";
                }
                if (i >= 100 && i < 1000) {
                    id = "1901100";
                }
                if (i >= 1000 && i < 10000) {
                    id = "190110";
                }
                stat.addBatch("insert into t_pig_info values (" + (id + i)
                        + ", 1, 120, 0, 1, 1, 1, '2019-10-19', 110, 3, 1, 1, 20, '2019-10-19', '2019-10-19')");
            }
//			for(i=4;i<10000;i++) {
//				stat.addBatch("insert into pig_variety value("+i+",'野猪');");
//			}

            stat.executeBatch();
            long end = System.currentTimeMillis();
            System.out.println("插入" + i + "条数据所需要的时间" + (end - start) + "ms");
            conn.commit();// 提交事务
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtil.closeAll(conn,stat, null);
        }
    }
    private void insertEnvironment(){

    }

    public static void main(String[] args) {
        BashInsert bs = new BashInsert();
        bs.insertPigInfo();
    }
}
