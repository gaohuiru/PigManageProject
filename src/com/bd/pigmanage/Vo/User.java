package com.bd.pigmanage.Vo;

import java.util.Map;

//InsertBean 测试对象
//@Setter
//@Getter
public class User
{
    private int id;
    private String name;
    private int age;

    public User(){}
    public User(int id, int age, String name)
    {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public User(Map<String,Object> map)
    {
        if(map.containsKey("name"))
            name= (String) map.get("name");
        if(map.containsKey("id"))
            id= (int) map.get("id");
        if(map.containsKey("age"))
            age= (int) map.get("age");

    }
    Example Example;

//    @Getter
//    @Setter
//    @AllArgsConstructor
    public static class Example
    {
        String[] db;
        String action;
        String index;
        String desc;
        String[] filed;
    }


}
