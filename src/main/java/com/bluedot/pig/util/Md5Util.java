package com.bluedot.pig.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * MD5加密工具
 * @author ly
 */
public class Md5Util {
    private static final String ENCODING="UTF-8";

    /**
     * 获取MD5加密的结果
     * @param str 传入字符串
     * @return 加密字符串
     */
    public static String getMd5Str(String str) {
        MessageDigest messageDigest = null;
        try {
            //获取MD5摘要对象
            messageDigest = MessageDigest.getInstance("MD5");
            //重置
            messageDigest.reset();
            //设置编码格式
            messageDigest.update(str.getBytes(ENCODING));
            byte[] byteArray = messageDigest.digest();
            StringBuilder md5StrBuff = new StringBuilder();

            for (byte b : byteArray) {
                //加盐gi
                if (Integer.toHexString(0xFF & b).length() == 1) {
                    md5StrBuff.append("0").append(Integer.toHexString(0xFF & b));
                } else {
                    md5StrBuff.append(Integer.toHexString(0xFF & b));
                }
            }
            return md5StrBuff.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

}
