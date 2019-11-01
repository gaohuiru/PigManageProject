package com.bd.pigmanage.test;


import com.bd.pigmanage.util.Md5Util;
import com.bd.pigmanage.util.SqlUtil;
import sun.security.provider.MD2;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CheckedOutputStream;

public class Test {
    public static void main(String[] args) {
        String str="1234abcd";
        System.out.println(Md5Util.getMD5Str(str));
        String[] beans=new String[1];
        beans[0]="VaccinationRecord";
        //beans[1]="PigVariety";
        Map<String, List<Object>> map=new HashMap<>();

        List<Object> ids=new ArrayList<>();
        int id=1001;
        ids.add(id);
        map.put("id",ids);


        List<Object> pyns=new ArrayList<>();
        int pyn=1;
        pyns.add(pyn);
        map.put("pigNo",pyns);
        List<Object> wheres=new ArrayList<>();
        String where1="pigNo";
        wheres.add(where1);
        String where2="pigRecentWeight";
        wheres.add(where2);
        map.put("where",wheres);


        // 观察其他类的信息对sql语句的干扰问题
        /*List<Object> pys=new ArrayList<>();
        String py="白猪";
        pys.add(py);
        map.put("pigVariety",pys);*/




        try{
            SqlUtil.updateSQL(beans,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
