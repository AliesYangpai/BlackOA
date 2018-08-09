package com.blackcoffee.work.test;

import java.io.Serializable;

/**
 * Created by admin on 2018/5/27.
 * 类描述
 * 版本
 */
public class TestWork implements Serializable{

    private int tag;//0：全部，1审批，2汇报，3客户，4公告
    private String title;
    private String time;
    private String name;
    private String describ;
    private String avatar;
    private String approveType;

    private String describTitle;


    public TestWork(int tag, String title, String time, String name, String describ, String avatar, String approveType, String describTitle) {
        this.tag = tag;
        this.title = title;
        this.time = time;
        this.name = name;
        this.describ = describ;
        this.avatar = avatar;
        this.approveType = approveType;
        this.describTitle = describTitle;
    }

    public TestWork(int tag, String title, String time, String name, String describ, String avatar) {
        this.tag = tag;
        this.title = title;
        this.time = time;
        this.name = name;
        this.describ = describ;
        this.avatar = avatar;
    }

    public TestWork(int tag, String title, String time, String name, String describ) {
        this.tag = tag;
        this.title = title;
        this.time = time;
        this.name = name;
        this.describ = describ;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getApproveType() {
        return approveType;
    }

    public void setApproveType(String approveType) {
        this.approveType = approveType;
    }

    public String getDescribTitle() {
        return describTitle;
    }

    public void setDescribTitle(String describTitle) {
        this.describTitle = describTitle;
    }


    @Override
    public String toString() {
        return "TestWork{" +
                "tag=" + tag +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", describ='" + describ + '\'' +
                ", avatar='" + avatar + '\'' +
                ", approveType='" + approveType + '\'' +
                ", describTitle='" + describTitle + '\'' +
                '}';
    }
}