package com.blackcoffee.work.entity;

import java.io.Serializable;

/**
 * Created by Alie on 2018/1/22.
 * 类描述  获取token的实体类
 * 版本
 */

public class TokenInfo implements Serializable{



    private String description;
    private String access_token;
    private int expires_in;


    public TokenInfo() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }


    @Override
    public String toString() {
        return "TokenInfo{" +
                "description='" + description + '\'' +
                ", access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
