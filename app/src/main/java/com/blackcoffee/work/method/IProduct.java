package com.blackcoffee.work.method;

import com.blackcoffee.work.listener.OnDataBackListener;

/**
 * Created by admin on 2018/5/4.
 * 类描述 企业产品相关
 * 版本
 */
public interface IProduct {


    /**
     *  创建企业产品
     * 【这个接口是有争议的，因为个人觉得 企业的产品 应该是有企业管理员与PC端创建更新产品，其他人只能浏览展品】
     * @param url
     * @param onDataBackListener
     */
    void doCreateProduct(String url, OnDataBackListener onDataBackListener);



    /**
     *  更新企业产品
     * 【这个接口是有争议的，因为个人觉得 企业的产品 应该是有企业管理员与PC端创建更新产品，其他人只能浏览展品】
     * @param url
     * @param onDataBackListener
     */
    void doUpdateProduct(String url,OnDataBackListener onDataBackListener);


    /**
     * 获取产品详情
     * @param url
     * @param onDataBackListener
     */
    void doGetProductInfo(String url,OnDataBackListener onDataBackListener);


    /**
     * 获取产品列表记录
     * @param url
     * @param size
     * @param index
     * @param onDataBackListener
     */
    void doGetWorkProductRecords(String url, int size, int index, OnDataBackListener onDataBackListener);

}