package com.blackcoffee.work.presenter;

import android.text.method.Touch;

import com.blackcoffee.work.listener.OnDataBackListener;
import com.blackcoffee.work.ui.IBaseUploadPermissionView;
import com.blackcoffee.work.universal.upload.BlackBinary;
import com.blackcoffee.work.universal.upload.method.IUpload;
import com.blackcoffee.work.universal.upload.method.impl.IUploadImpl;
import com.blackcoffee.work.util.ToastUtil;
import com.yanzhenjie.nohttp.FileBinary;
import com.yanzhenjie.nohttp.OnUploadListener;

/**
 * Created by admin on 2018/5/7.
 * 类描述
 * 版本
 */
public class PresenterTest  extends BasePresenter<IBaseUploadPermissionView> {


    private IBaseUploadPermissionView iBaseUploadPermissionView;
    private IUpload iUpload;
    private BlackBinary blackBinary;


    public PresenterTest(IBaseUploadPermissionView iBaseUploadPermissionView) {
        this.iBaseUploadPermissionView = iBaseUploadPermissionView;
        this.iUpload = new IUploadImpl();
        this.blackBinary = new BlackBinary();
    }




    public void doUploadSingle(String url,String filepath,OnUploadListener onUploadListener) {



        FileBinary fileBinary = blackBinary.getSingleFileUploloadBinary(filepath, onUploadListener);

        iUpload.doSingleUpLoad(url, fileBinary, new OnDataBackListener() {
            @Override
            public void onStart() {
                iBaseUploadPermissionView.showLoadingDialog();
            }

            @Override
            public void onSuccess(String data) {

                /**
                 * 这里是上传成功的回调
                 */
            }

            @Override
            public void onFail(int code, String data) {

                iBaseUploadPermissionView.onDataBackFail(code,data);

            }

            @Override
            public void onFinish() {
                iBaseUploadPermissionView.dismissLoadingDialog();
            }
        });
    }

}