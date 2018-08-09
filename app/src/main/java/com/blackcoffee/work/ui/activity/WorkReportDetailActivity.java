package com.blackcoffee.work.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstHz;
import com.blackcoffee.work.presenter.PresenterWorkReportDetail;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.IWorkReportDetailView;
import com.blackcoffee.work.ui.widget.DrawableInText;
import com.blackcoffee.work.ui.widget.cirlceimageview.CircleImageView;
import com.blackcoffee.work.universal.img.ImgUtil;
import com.blackcoffee.work.util.ToastUtil;

public class WorkReportDetailActivity extends BaseActivity<IWorkReportDetailView, PresenterWorkReportDetail> implements
        IWorkReportDetailView,
        View.OnClickListener {


    private PresenterWorkReportDetail presenterWorkReportDetail;


    /**
     * titlle
     */
    private ImageView iv_common_back;
    private TextView tv_common_title;


    private TextView tv_report_type;
    private TextView tv_user_name;
    private TextView tv_create_time;
    private TextView tv_finished_work;
    private TextView tv_unfinished_work;
    private TextView tv_coordinate_work;
    private TextView tv_remark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_report_detail);
        doTestInit();
    }


    private void doTestInit() {






        tv_report_type.setText(ConstHz.DAY);
        tv_user_name.setText("王富贵");
        tv_create_time.setText("2018-04-27 19:38");
        tv_finished_work.setText(" 1.工作添加展开界面，已完成" +
                " 2.公告列表、公告详情接口定义完成 3.工作添加展开界面，已完成工作添加展开界面，已完成 工作添加展开界面，已完成 ");
        tv_unfinished_work.setText("公告列表、公告详情接口定");
        tv_coordinate_work.setText("无");
        tv_remark.setText("发布司机端最新版本");

    }

    @Override
    protected PresenterWorkReportDetail creatPresenter() {
        if (null == presenterWorkReportDetail) {

            presenterWorkReportDetail = new PresenterWorkReportDetail(this);
        }

        return presenterWorkReportDetail;
    }

    @Override
    protected void initViews() {


        /**
         * titlle
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        tv_common_title = findOAViewById(R.id.tv_common_title);
        tv_common_title.setText(R.string.work_report_2);



        tv_report_type = findOAViewById(R.id.tv_report_type);
        tv_user_name = findOAViewById(R.id.tv_user_name);
        tv_create_time = findOAViewById(R.id.tv_create_time);
        tv_finished_work = findOAViewById(R.id.tv_finished_work);
        tv_unfinished_work = findOAViewById(R.id.tv_unfinished_work);
        tv_coordinate_work = findOAViewById(R.id.tv_coordinate_work);
        tv_remark = findOAViewById(R.id.tv_remark);
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
}
