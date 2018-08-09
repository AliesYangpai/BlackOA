package com.blackcoffee.work.ui.activity;

import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.presenter.PresenterQRScanAddContact;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.IQRScanAddContactView;
import com.blackcoffee.work.util.ToastUtil;

import cn.bingoogolapple.qrcode.core.QRCodeView;

public class QRScanAddContactActivity extends BaseActivity<IQRScanAddContactView,PresenterQRScanAddContact> implements
        IQRScanAddContactView,
        OnClickListener,
        QRCodeView.Delegate{


    private PresenterQRScanAddContact presenterQRScanAddContact;




    /**
     * title
     */
    private ImageView iv_common_back;
    private TextView tv_common_title;




    /**
     * 二维码控件
     */

    private QRCodeView mQRCodeView;
    private Vibrator vibrator;//震动控件


    private void startVibrate() {
        if (null == vibrator) {
            vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        }
        vibrator.vibrate(200);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scan_add_contact);
        mQRCodeView.setDelegate(this);
        mQRCodeView.startSpot();
    }


    @Override
    protected void onStart() {
        super.onStart();

        if (null != mQRCodeView) {

            mQRCodeView.startCamera();
            mQRCodeView.showScanRect();
            mQRCodeView.startSpot();
        }
    }


    @Override
    protected void onStop() {
        if (null != mQRCodeView) {

            mQRCodeView.stopCamera();
            mQRCodeView.stopSpot();

        }
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        if (null != mQRCodeView) {
            mQRCodeView.onDestroy();
        }
        super.onDestroy();
    }

    @Override
    protected PresenterQRScanAddContact creatPresenter() {
        if(null == presenterQRScanAddContact) {

            presenterQRScanAddContact = new PresenterQRScanAddContact(this);
        }
        return presenterQRScanAddContact;
    }

    @Override
    protected void initViews() {

        /**
         * title
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        tv_common_title = findOAViewById(R.id.tv_common_title);
        tv_common_title.setText(R.string.sweep_scan);


        iv_common_back.setImageResource(R.drawable.img_back_white);
        /**
         * 二维码控件
         *
         */

        mQRCodeView = findOAViewById(R.id.mQRCodeView);
    }

    @Override
    protected void initListener() {
        iv_common_back.setOnClickListener(this);
    }

    @Override
    protected void processIntent() {

    }

    @Override
    public void showLoadingDialog() {
        showLoadDialog();
    }

    @Override
    public void dismissLoadingDialog() {
        dismissLoadDialog();
    }

    @Override
    public void onDataBackFail(int code, String errorMsg) {
        ToastUtil.showMsg(getApplicationContext(),errorMsg);
        mQRCodeView.startSpot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_common_back:
                dofinishItself();
                break;
        }
    }

    @Override
    public void onScanQRCodeSuccess(String result) {

        ToastUtil.showMsg(getApplicationContext(), result +" ");
        Log.i("scanResult", result);
        startVibrate();
//        mQRCodeView.startSpot();
        mQRCodeView.stopSpot();


//        presenterQRScan.doOutPutWater(HttpConst.URL.OUT_PUT_WATER, result, ConstSign.DOUBLE_QUOTE);

    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        ToastUtil.showMsg(getApplicationContext(), R.string.error_sweep_device);
    }
}
