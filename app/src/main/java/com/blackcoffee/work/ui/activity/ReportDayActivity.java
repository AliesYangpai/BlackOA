package com.blackcoffee.work.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.callback.PopWindowLayoutItemClickCallBack;
import com.blackcoffee.work.presenter.PresenterMain;
import com.blackcoffee.work.presenter.PresenterReportDay;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.fragment.FragmentReportDayScan;
import com.blackcoffee.work.ui.fragment.FragmentReportDayWrite;
import com.blackcoffee.work.ui.iview.IReportDayView;
import com.blackcoffee.work.ui.widget.popwindow.PopWindowLayout;
import com.blackcoffee.work.util.ToastUtil;

/**
 * 日报的activity
 */
public class ReportDayActivity extends BaseActivity<IReportDayView, PresenterReportDay> implements
        IReportDayView,
        View.OnClickListener,
        PopWindowLayoutItemClickCallBack {


    private PresenterReportDay presenterReportDay;

    /**
     * title
     */

    private ImageView iv_common_back;

    private PopWindowLayout pwl_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_day);

        presenterReportDay.doGetDifferentFragment(FragmentReportDayWrite.TAG);
    }

    @Override
    protected PresenterReportDay creatPresenter() {

        if (null == presenterReportDay) {

            FragmentManager fragmentManager = getSupportFragmentManager();

            presenterReportDay = new PresenterReportDay(this, fragmentManager, fragmentManager.beginTransaction());
        }
        return presenterReportDay;


    }

    @Override
    protected void initViews() {
        /**
         * title
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        pwl_title = findOAViewById(R.id.pwl_title);
        pwl_title.doSetData(TestContent.getReportDayList());
    }

    @Override
    protected void initListener() {
        iv_common_back.setOnClickListener(this);
        pwl_title.setPopWindowLayoutItemClickCallBack(this);
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
        ToastUtil.showMsg(getApplicationContext(), errorMsg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.iv_common_back:
                dofinishItself();
                break;



        }
    }

    @Override
    public void onClickItemScan() {
        presenterReportDay.doGetDifferentFragment(FragmentReportDayScan.TAG);
    }

    @Override
    public void onClickItemWrite() {
        presenterReportDay.doGetDifferentFragment(FragmentReportDayWrite.TAG);
    }

//    @Override
//    public void onClickItemScan() {
//
//        presenterReportDay.doGetDifferentFragment(FragmentReportDayScan.TAG);
//    }
//
//    @Override
//    public void onClickItemWrite() {
//        presenterReportDay.doGetDifferentFragment(FragmentReportDayWrite.TAG);
//    }
}
