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
    private int maxAge;

    public User(){}
    public User(int id, String name,int age, int maxAge )
    {
        this.id = id;
        this.age = age;
        this.name = name;
        this.maxAge=maxAge;
    }

    public User(Map<String,Object> map)
    {
        if(map.containsKey("name"))
            name= (String) map.get("name");
        if(map.containsKey("id"))
            id= (int) map.get("id");
        if(map.containsKey("age"))
            age= (int) map.get("age");
        if(map.containsKey("age"))
            maxAge= (int) map.get("maxAge");

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
