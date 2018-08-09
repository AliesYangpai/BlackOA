package com.blackcoffee.work.method;

import com.blackcoffee.work.listener.OnDataBackListener;

/**
 * Created by admin on 2018/5/4.
 * 类描述  考勤相关方法
 * 版本
 */
public interface IWorkCheckAbout {




    /**
     * 上班打卡
     * @param url
     * @param onDataBackListener
     */
    void doClockIn(String url,OnDataBackListener onDataBackListener);


    /**
     * 下班打卡
     * @param url
     * @param onDataBackListener
     */
    void doClockOut(String url,OnDataBackListener onDataBackListener);


    /**
     * 打卡更新
     * @param url
     * @param onDataBackListener
     */
    void doClockCheckUpdate(String url,OnDataBackListener onDataBackListener);




    /**
     * 获取考勤列表记录
     */
    void doGetWorkAttendanceRecords(String url, int size, int index, OnDataBackListener onDataBackListener);
}