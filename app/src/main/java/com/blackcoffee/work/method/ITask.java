package com.blackcoffee.work.method;

import com.blackcoffee.work.listener.OnDataBackListener;

/**
 * Created by admin on 2018/5/4.
 * 类描述 任务相关
 * 版本
 */
public interface ITask {


    /**
     * 创建任务
     * @param url
     * @param onDataBackListener
     */
    void doCreateTask(String url, OnDataBackListener onDataBackListener);


    /**
     * 编辑任务
     * @param url
     * @param onDataBackListener
     */
    void doEditTask(String url,OnDataBackListener onDataBackListener);


    /**
     * 提交任务
     * @param url
     * @param onDataBackListener
     */
    void doSubmitTask(String url,OnDataBackListener onDataBackListener);


    /**
     * 获取任务详情
     * @param url
     * @param onDataBackListener
     */
    void doGetTaskInfo(String url,OnDataBackListener onDataBackListener);




    /**
     * 获取任务列表记录
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetTaskRecords(String url, int size, int index, OnDataBackListener onDataBackListener);

}