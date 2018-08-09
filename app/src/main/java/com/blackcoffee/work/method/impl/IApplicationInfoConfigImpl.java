package com.blackcoffee.work.method.impl;

import com.blackcoffee.work.constant.HttpConst;
import com.blackcoffee.work.listener.OnDataBackListener;
import com.blackcoffee.work.method.IApplicationInfoConfig;
import com.blackcoffee.work.universal.http.CallServer;
import com.blackcoffee.work.universal.http.HttpSingleResponseListener;
import com.blackcoffee.work.universal.http.RequestPacking;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;

/**
 * Created by admin on 2018/5/21.
 * 类描述 应用界面配置项目方法实现类
 * 版本
 */
public class IApplicationInfoConfigImpl implements IApplicationInfoConfig {






    @Override
    public void doGetApplicationRecords(String url, int size, int index, final OnDataBackListener onDataBackListener) {



        Request<String> request = RequestPacking.getInstance().getRequestParamForJson(
                url,
                RequestMethod.GET,
                null);

        request.add("size",size);
        request.add("index", index);



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
}