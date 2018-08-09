package com.blackcoffee.work.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackcoffee.work.R;
import com.blackcoffee.work.entity.EventEntity;
import com.blackcoffee.work.presenter.PresenterReportDayScan;
import com.blackcoffee.work.ui.BaseFragment;
import com.blackcoffee.work.ui.iview.fg.IFgReportDayScanView;
import com.blackcoffee.work.util.ToastUtil;

/**
 * reportDayScan的fg,此fg会嵌套子fg
 */
public class FragmentReportDayScan extends BaseFragment<IFgReportDayScanView,PresenterReportDayScan> implements IFgReportDayScanView{


    public static final String TAG = FragmentReportDayScan.class.getSimpleName();

    private PresenterReportDayScan presenterReportDayScan;

    public FragmentReportDayScan() {
        // Required empty public constructor
    }



    @Override
    protected PresenterReportDayScan creatPresenter() {
        if(null == presenterReportDayScan) {
            presenterReportDayScan = new PresenterReportDayScan(this);
        }
        return presenterReportDayScan;

    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_report_day_scan;
    }

    @Override
    protected void getSendData(Bundle arguments) {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onLazyLoad() {

    }

    @Override
    protected void onEventBack(EventEntity eventEntity) {

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
        ToastUtil.showMsg(mActivity.getApplicationContext(),errorMsg);
    }
}
