package com.bluedot.pig.pojo.domain;

/**
 * User.java
 *
 * @author PLF
 * @date 2019年3月6日
 */
public class User {
    /**
     * the id
     */
    private Integer id;

    /**
     * the name
     */
    private String username;

    private String password;

    private Integer ifFreeze;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIfFreeze() {
        return ifFreeze;
    }

    public void setIfFreeze(Integer ifFreeze) {
        this.ifFreeze = ifFreeze;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ifFreeze=" + ifFreeze +
                '}';
    }
}
