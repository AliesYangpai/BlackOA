package com.blackcoffee.work.method;

import com.blackcoffee.work.listener.OnDataBackListener;

/**
 * Created by admin on 2018/5/7.
 * 类描述  市场活动的请求接口
 * 版本
 */
public interface IActive {


    /**
     * 创建市场活动
     * @param url
     * @param onDataBackListener
     */
    void doCreateActive(String url, OnDataBackListener onDataBackListener);


    /**
     * 更新市场活动
     * @param url
     * @param onDataBackListener
     */
    void doUpdateActive(String url,OnDataBackListener onDataBackListener);


    /**
     * 获取活动详情
     * @param url
     * @param onDataBackListener
     */
    void doGetActiveInfo(String url,OnDataBackListener onDataBackListener);

    /**
     * 获取市场活动列表
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetActiveRecords(String url, int size, int index, OnDataBackListener onDataBackListener);
}