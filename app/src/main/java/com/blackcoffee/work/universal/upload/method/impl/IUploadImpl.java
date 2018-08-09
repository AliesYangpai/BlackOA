package com.blackcoffee.work.universal.upload.method.impl;

import com.blackcoffee.work.constant.HttpConst;
import com.blackcoffee.work.listener.OnDataBackListener;
import com.blackcoffee.work.universal.http.CallServer;
import com.blackcoffee.work.universal.http.HttpSingleResponseListener;
import com.blackcoffee.work.universal.http.RequestPacking;
import com.blackcoffee.work.universal.upload.method.IUpload;
import com.yanzhenjie.nohttp.Binary;
import com.yanzhenjie.nohttp.FileBinary;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;

import java.util.List;

/**
 * Created by admin on 2018/5/7.
 * 类描述
 * 版本
 */
public class IUploadImpl implements IUpload {


    @Override
    public void doSingleUpLoad(String url, FileBinary fileBinary, final OnDataBackListener onDataBackListener) {
        Request<String> request = RequestPacking.getInstance().getRequestParamForUpLoad(url,fileBinary, RequestMethod.POST);

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
                onDataBackListener.onFail(response.responseCode(),response.get());
            }

            @Override
            protected void OnHttpFinish(int what) {
                onDataBackListener.onFinish();
            }
        });
    }

//    @Override
//    public void doMultiUpload(String url, List<Binary> binaries, final OnDataBackListener onDataBackListener) {
//
//        Request<String> request = RequestPacking.getInstance().getRequestParamForUpLoadMulti(url,binaries, RequestMethod.POST);
//
//        CallServer.getInstance().add(HttpConst.HTTP_WHAT, request, new HttpSingleResponseListener<String>() {
//            @Override
//            protected void OnHttpStart(int what) {
//                onDataBackListener.onStart();
//            }
//
//            @Override
//            protected void OnHttpSuccessed(int what, Response<String> response) {
//                onDataBackListener.onSuccess(response.get());
//            }
//
//            @Override
//            protected void onHttpFailed(int what, Response<String> response) {
//                onDataBackListener.onFail(response.responseCode(),response.get());
//            }
//
//            @Override
//            protected void OnHttpFinish(int what) {
//                onDataBackListener.onFinish();
//            }
//        });
//    }
}