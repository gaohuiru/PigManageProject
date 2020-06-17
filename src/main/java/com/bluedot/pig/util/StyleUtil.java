package com.bluedot.pig.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 变量名的驼峰和下划线相互转换(下划线转驼峰还有首字母问题待处理) 如将_ass_ass转化为assAss还不能实现，目前对这种形式的转换也没有需求
 * @author AlwaysXu
 */
public class StyleUtil {
    private static Pattern linePattern = Pattern.compile("_(\\w)");
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 下划线转驼峰 将下划线改成类的命名形式如 ass_ass转为AssAss
     * @param str
     * @return
     */
    public static String lineToHump(String str) {
        //
        str = str.toLowerCase();
        //将首字母先进行大写转换
        String newStr=str.substring(0,1).toUpperCase()+str.substring(1);
        Matcher matcher = linePattern.matcher(newStr);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 驼峰转下划线
     * @param str
     * @return
     */
    public static String humpToLine(String str) {
        //将首字母先进行小写转换
        String newStr=str.substring(0,1).toLowerCase()+str.substring(1);
        //比对字符串中的大写字符
        Matcher matcher = humpPattern.matcher(newStr);
        StringBuffer sb = new StringBuffer();
        //匹配替换
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        String str="_ass_ass";
        System.out.println(lineToHump(str));
    }
}

