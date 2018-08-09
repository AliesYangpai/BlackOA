package com.blackcoffee.work.method;

import com.blackcoffee.work.listener.OnDataBackListener;

/**
 * Created by admin on 2018/5/7.
 * 类描述  项目相关接口方法
 * 版本
 */
public interface IProject {


    /**
     * 创建项目
     * @param url
     * @param onDataBackListener
     */
    void doCreateProject(String url, OnDataBackListener onDataBackListener);


    /**
     * 更新项目
     * @param url
     * @param onDataBackListener
     */
    void doUpdateProject(String url,OnDataBackListener onDataBackListener);


    /**
     * 获取项目详情
     * @param url
     * @param onDataBackListener
     */
    void doGetProjectInfo(String url,OnDataBackListener onDataBackListener);


    /**
     * 获取项目列表
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetProjectRecords(String url, int size, int index, OnDataBackListener onDataBackListener);


}