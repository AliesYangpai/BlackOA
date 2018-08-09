package com.blackcoffee.work.method;

import com.blackcoffee.work.listener.OnDataBackListener;

/**
 * Created by admin on 2018/5/29.
 * 类描述  公告相关
 * 版本
 */
public interface IAnnounce {

    /**
     * 获取公告详情
     * @param url
     * @param onDataBackListener
     */
    void doGetAnnounceInfo(String url,OnDataBackListener onDataBackListener);


    /**
     * 获取公告列表
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetIAnnounceRecords(String url, int size, int index, OnDataBackListener onDataBackListener);

}