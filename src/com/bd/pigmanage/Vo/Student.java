package com.bd.pigmanage.Vo;

import java.util.Map;

//
//@Setter
//@Getter
//@AllArgsConstructor

//insertBean 测试案例
public class Student
{
    private int id;
    private String name;
    private String sex;

    public Student(Map<String,Object> map)
    {
        if(map.containsKey("id"))
            id= (int) map.get("id");
        if(map.containsKey("name"))
            name= (String) map.get("name");
        if(map.containsKey("sex"))
            sex= (String) map.get("sex");
    }
}
