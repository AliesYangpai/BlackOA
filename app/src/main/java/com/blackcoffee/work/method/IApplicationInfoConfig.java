package com.blackcoffee.work.method;

import com.blackcoffee.work.listener.OnDataBackListener;

/**
 * Created by admin on 2018/5/21.
 * 类描述 应用界面配置项目方法
 * 版本
 */
public interface IApplicationInfoConfig {


    /**
     * 获取应用配置的列表
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetApplicationRecords(String url, int size, int index, OnDataBackListener onDataBackListener);

}