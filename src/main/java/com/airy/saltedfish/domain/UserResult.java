package com.airy.saltedfish.domain;

/**
 * Created by Airy on 2018/8/21
 */

public class UserResult{

    private Integer id;

    private String userName;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
