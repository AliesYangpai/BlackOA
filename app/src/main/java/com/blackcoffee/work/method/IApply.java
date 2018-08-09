package com.blackcoffee.work.method;

import com.blackcoffee.work.listener.OnDataBackListener;

/**
 * Created by admin on 2018/5/4.
 * 类描述  工作申请接口
 * 版本
 */
public interface IApply {


    /**
     * 创建工作申请
     * @param url
     * @param onDataBackListener
     */
    void doCreateWorkApply(String url, OnDataBackListener onDataBackListener);


    /**
     * 更新工作申请
     * @param url
     * @param onDataBackListener
     */
    void doUpdateWorkApply(String url,OnDataBackListener onDataBackListener);



    /**
     * 获取工作申请详情
     * @param url
     * @param onDataBackListener
     */
    void doGetWorkApplyInfo(String url,OnDataBackListener onDataBackListener);


    /**
     * 获取工作申请列表记录
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetWorkApplyRecords(String url, int size, int index, OnDataBackListener onDataBackListener);

}