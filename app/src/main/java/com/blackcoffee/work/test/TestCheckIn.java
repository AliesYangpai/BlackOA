package com.blackcoffee.work.test;

/**
 * Created by admin on 2018/6/5.
 * 类描述
 * 版本
 */
public class TestCheckIn {


    private String workTime;
    private String checkTime;
    private String location;
    private String status;







    public TestCheckIn(String workTime, String checkTime, String location, String status) {
        this.workTime = workTime;
        this.checkTime = checkTime;
        this.location = location;
        this.status = status;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TestCheckIn{" +
                "workTime='" + workTime + '\'' +
                ", checkTime='" + checkTime + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}