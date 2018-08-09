package com.blackcoffee.work.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.presenter.PresenterWorkAdd;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.IWorkAddView;
import com.blackcoffee.work.util.ToastUtil;

public class WorkAddActivity extends BaseActivity<IWorkAddView, PresenterWorkAdd> implements IWorkAddView,
        View.OnClickListener {


    private PresenterWorkAdd presenterWorkAdd;


    private RelativeLayout rl_root;


    private TextView tv_go_check_in;
    private TextView tv_go_publish_announce;
    private TextView tv_go_diary;
    private TextView tv_go_approval;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_add);
    }

    @Override
    protected PresenterWorkAdd creatPresenter() {

        if (null == presenterWorkAdd) {

            presenterWorkAdd = new PresenterWorkAdd(this);
        }

        return presenterWorkAdd;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initViews() {
        rl_root = findOAViewById(R.id.rl_root);

        tv_go_check_in = findOAViewById(R.id.tv_go_check_in);
        tv_go_publish_announce = findOAViewById(R.id.tv_go_publish_announce);
        tv_go_diary = findOAViewById(R.id.tv_go_diary);
        tv_go_approval = findOAViewById(R.id.tv_go_approval);
    }


    @Override
    protected void initListener() {
        rl_root.setOnClickListener(this);

        tv_go_check_in.setOnClickListener(this);
        tv_go_publish_announce.setOnClickListener(this);
        tv_go_diary.setOnClickListener(this);
        tv_go_approval.setOnClickListener(this);

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

            case R.id.rl_root:
                dofinishItself();
                break;

            case R.id.tv_go_check_in:
                ToastUtil.showMsg(this, "去打卡");
                break;
            case R.id.tv_go_publish_announce:
                ToastUtil.showMsg(this, "发公告");
                break;
            case R.id.tv_go_diary:
                ToastUtil.showMsg(this, "写日志");
                break;
            case R.id.tv_go_approval:
                ToastUtil.showMsg(this, "提审批");
                break;
        }
    }
}
