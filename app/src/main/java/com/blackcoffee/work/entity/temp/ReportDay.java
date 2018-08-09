package com.blackcoffee.work.entity.temp;

/**
 * Created by admin on 2018/6/8.
 * 类描述
 * 版本
 */
public class ReportDay {

    private int type;   //"0:写日报，1：查看日报"
    private String typeName;


    public ReportDay(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    @Override
    public String toString() {
        return "ReportDay{" +
                "type=" + type +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}