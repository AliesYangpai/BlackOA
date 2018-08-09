package com.blackcoffee.work.method;

import com.blackcoffee.work.listener.OnDataBackListener;

/**
 * Created by admin on 2018/5/4.
 * 类描述  获取记录的方法  【本接口有争议，待定】
 * 版本
 */
public interface IRecord {


    /**
     * 获取考勤列表记录
     */
    void doGetWorkAttendanceRecords(String url, int size, int index, OnDataBackListener onDataBackListener);


    /**
     * 获取工作申请列表记录
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetWorkApplyRecords(String url, int size, int index, OnDataBackListener onDataBackListener);


    /**
     * 获取工作汇报列表记录
     * @param url
     * @param tag
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetWorkReportRecords(String url,int tag,int size,int index,OnDataBackListener onDataBackListener);


    /**
     * 获取产品列表记录
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetWorkProductRecords(String url, int size, int index, OnDataBackListener onDataBackListener);


    /**
     * 获取任务列表记录
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetTaskRecords(String url, int size, int index, OnDataBackListener onDataBackListener);




    /**
     * 获取市场活动列表
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetActiveRecords(String url, int size, int index, OnDataBackListener onDataBackListener);




    /**
     * 获取项目列表
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetProjectRecords(String url, int size, int index, OnDataBackListener onDataBackListener);




    /**
     * 获取应用配置的列表
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetApplicationRecords(String url, int size, int index, OnDataBackListener onDataBackListener);


    /**
     * 获取公告列表
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetAnnounceRecords(String url, int size, int index, OnDataBackListener onDataBackListener);
}