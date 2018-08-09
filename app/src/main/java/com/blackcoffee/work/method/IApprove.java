package com.blackcoffee.work.method;

import com.blackcoffee.work.listener.OnDataBackListener;

/**
 * Created by admin on 2018/5/4.
 * 类描述  审批相关方法
 * 版本
 */
public interface IApprove {


    /**
     * 审批通过
     * @param url
     * @param onDataBackListener
     */
    void doApprove(String url, OnDataBackListener onDataBackListener);


    /**
     * 审批拒绝
     * @param url
     * @param onDataBackListener
     */
    void doReject(String url,OnDataBackListener onDataBackListener);


    /**
     * 撤销
     * @param url
     * @param onDataBackListener
     */
    void doRepeal(String url,OnDataBackListener onDataBackListener);
}