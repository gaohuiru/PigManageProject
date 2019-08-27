package com.bd.pigmanage.test;


import com.bd.pigmanage.util.Md5Util;
import sun.security.provider.MD2;

import java.sql.SQLOutput;
import java.util.zip.CheckedOutputStream;

public class Test {
    public static void main(String[] args) {
        String str="1234abcd";
        System.out.println(Md5Util.getMD5Str(str));
    }



}
