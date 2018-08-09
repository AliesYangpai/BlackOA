package com.blackcoffee.work.method;

import com.blackcoffee.work.listener.OnDataBackListener;

/**
 * Created by admin on 2018/5/4.
 * 类描述  用户模块相关接口
 * 版本
 */
public interface IUser {



    /**
     * 用户注册
     *
     * @param url
     * @param phone
     * @param user_name
     * @param password
     * @param pass_code
     * @param user_points
     */
    void doRegister(String url,
                    String phone,
                    String user_name,
                    String password,
                    String pass_code,
                    String user_points,
                    OnDataBackListener onDataBackListener);




    /**
     * 获取用户token（功能等同于登录）
     * @param url
     * @param user_name
     * @param password
     */
    void doGetAccessToken(String url,String user_name,String password, OnDataBackListener onDataBackListener);


    /**
     * 用户登录
     * @param url
     * @param user_name
     * @param password
     * @param onDataBackListener
     */
    void doLogon(String url,String user_name,String password, OnDataBackListener onDataBackListener);

    /**
     * 用户退出
     * @param url
     * @param onDataBackListener
     */
    void doLogout(String url,OnDataBackListener onDataBackListener);

    /**
     * 获取用户信息信息
     * @param url
     * @param onDataBackListener
     */
    void doGetUserInfo(String url,OnDataBackListener onDataBackListener);



    void doResetPass(String url,String pass,OnDataBackListener onDataBackListener);


    /**
     * 重置登录密码
     * @param url
     * @param phone
     * @param passcode
     * @param new_password
     * @param onDataBackListener
     */
    void doResetPass(String url,
                     String phone,
                     String passcode,
                     String new_password,
                     OnDataBackListener onDataBackListener);

}