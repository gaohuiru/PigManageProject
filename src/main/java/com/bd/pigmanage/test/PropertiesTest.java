package com.bd.pigmanage.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        Properties pro=new Properties();
        InputStream is= PropertiesTest.class.getClassLoader().getResourceAsStream("DataTable.properties");
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pro.getProperty("feedStandard"));
    }
}
