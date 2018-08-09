package com.blackcoffee.work.method.impl;

import com.blackcoffee.work.constant.HttpConst;
import com.blackcoffee.work.listener.OnDataBackListener;
import com.blackcoffee.work.method.IUser;
import com.blackcoffee.work.universal.http.CallServer;
import com.blackcoffee.work.universal.http.HttpSingleResponseListener;
import com.blackcoffee.work.universal.http.RequestPacking;
import com.blackcoffee.work.universal.http.requestparam.UserParam;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;

/**
 * Created by admin on 2018/5/4.
 * 类描述  用户相关操作的实现类
 * 版本
 */
public class IUserImpl implements IUser {


    private UserParam userParam;


    public IUserImpl() {
        this.userParam = new UserParam();
    }

    @Override
    public void doRegister(String url,
                           String phone,
                           String user_name,
                           String password,
                           String pass_code,
                           String user_points, final OnDataBackListener onDataBackListener) {


        String param = userParam.getRegisterParam(phone, user_name, password, pass_code, user_points);

        Request<String> request = RequestPacking.getInstance().getRequestParamForJsonNoToken(url, RequestMethod.POST, param);

        CallServer.getInstance().add(HttpConst.HTTP_WHAT, request, new HttpSingleResponseListener<String>() {
            @Override
            protected void OnHttpStart(int what) {
                onDataBackListener.onStart();
            }

            @Override
            protected void OnHttpSuccessed(int what, Response<String> response) {
                onDataBackListener.onSuccess(response.get());
            }

            @Override
            protected void onHttpFailed(int what, Response<String> response) {
                onDataBackListener.onFail(response.responseCode(), response.get());
            }

            @Override
            protected void OnHttpFinish(int what) {
                onDataBackListener.onFinish();
            }
        });

    }

    @Override
    public void doGetAccessToken(String url, String user_name, String password, final OnDataBackListener onDataBackListener) {


        String param = userParam.getLogonParam(user_name, password);

        Request<String> request = RequestPacking.getInstance().getRequestParamForJsonNoToken(url, RequestMethod.POST, param);

        CallServer.getInstance().add(HttpConst.HTTP_WHAT, request, new HttpSingleResponseListener<String>() {
            @Override
            protected void OnHttpStart(int what) {
                onDataBackListener.onStart();
            }

            @Override
            protected void OnHttpSuccessed(int what, Response<String> response) {
                onDataBackListener.onSuccess(response.get());
            }

            @Override
            protected void onHttpFailed(int what, Response<String> response) {
                onDataBackListener.onFail(response.responseCode(), response.get());
            }

            @Override
            protected void OnHttpFinish(int what) {
                onDataBackListener.onFinish();
            }
        });

    }


    @Override
    public void doLogon(String url,
                        String user_name,
                        String password, final OnDataBackListener onDataBackListener) {

        String param = userParam.getLogonParam(user_name, password);

        Request<String> request = RequestPacking.getInstance().getRequestParamForJsonNoToken(url, RequestMethod.POST, param);

        CallServer.getInstance().add(HttpConst.HTTP_WHAT, request, new HttpSingleResponseListener<String>() {
            @Override
            protected void OnHttpStart(int what) {
                onDataBackListener.onStart();
            }

            @Override
            protected void OnHttpSuccessed(int what, Response<String> response) {
                onDataBackListener.onSuccess(response.get());
            }

            @Override
            protected void onHttpFailed(int what, Response<String> response) {
                onDataBackListener.onFail(response.responseCode(), response.get());
            }

            @Override
            protected void OnHttpFinish(int what) {
                onDataBackListener.onFinish();
            }
        });

    }

    @Override
    public void doLogout(String url, OnDataBackListener onDataBackListener) {

    }


    @Override
    public void doGetUserInfo(String url, final OnDataBackListener onDataBackListener) {


        Request<String> request = RequestPacking.getInstance().getRequestParamForJson(url, RequestMethod.GET, null);

        CallServer.getInstance().add(HttpConst.HTTP_WHAT, request, new HttpSingleResponseListener<String>() {
            @Override
            protected void OnHttpStart(int what) {
                onDataBackListener.onStart();
            }

            @Override
            protected void OnHttpSuccessed(int what, Response<String> response) {
                onDataBackListener.onSuccess(response.get());
            }

            @Override
            protected void onHttpFailed(int what, Response<String> response) {
                onDataBackListener.onFail(response.responseCode(), response.get());
            }

            @Override
            protected void OnHttpFinish(int what) {
                onDataBackListener.onFinish();
            }
        });

    }


    @Override
    public void doResetPass(String url, String pass, OnDataBackListener onDataBackListener) {

    }

    @Override
    public void doResetPass(String url, String phone, String passcode, String new_password, OnDataBackListener onDataBackListener) {

    }

}