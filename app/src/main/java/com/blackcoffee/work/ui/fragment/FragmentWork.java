package com.blackcoffee.work.ui.fragment;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstLocalData;
import com.blackcoffee.work.entity.EventEntity;
import com.blackcoffee.work.presenter.PresenterMain;
import com.blackcoffee.work.presenter.fg.PresenterFgWork;
import com.blackcoffee.work.ui.BaseFragment;
import com.blackcoffee.work.ui.activity.WorkAddActivity;
import com.blackcoffee.work.ui.iview.fg.IFgWorkView;
import com.blackcoffee.work.util.BlurUtil;
import com.blackcoffee.work.util.ToastUtil;

import java.io.ByteArrayOutputStream;


/**
 * 工作的fragment
 */
public class FragmentWork extends BaseFragment<IFgWorkView, PresenterFgWork> implements
        IFgWorkView,
        TabLayout.OnTabSelectedListener,
        View.OnClickListener{


    public static final String TAG = FragmentWork.class.getSimpleName();
    private PresenterFgWork presenterFgWork;

    /**
     * title
     */
    private TextView tv_left;
    private TabLayout tl_work;


    /**
     * 底部
     *
     * @return
     */

    private ImageView iv_add;


    @Override
    protected PresenterFgWork creatPresenter() {
        if (null == presenterFgWork) {

            FragmentManager fragmentManager = getChildFragmentManager();

            presenterFgWork = new PresenterFgWork(this, fragmentManager, fragmentManager.beginTransaction());
        }

        return presenterFgWork;
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_work;
    }

    @Override
    protected void getSendData(Bundle arguments) {

    }

    @Override
    protected void initView() {


        /**
         * title
         */
        tv_left = findOAViewById(R.id.tv_left);
        tl_work = findOAViewById(R.id.tl_work);


        /**
         * 这里需要注意下，当我们添加table的时候，就会直接调用addOnTabSelectedListener
         * 所以addOnTabSelectedListener 要写在addTab前面
         */
        tl_work.addOnTabSelectedListener(this);
        tl_work.addTab(tl_work.newTab().setText(mActivity.getString(R.string.work_all)));
        tl_work.addTab(tl_work.newTab().setText(mActivity.getString(R.string.approve)));
        tl_work.addTab(tl_work.newTab().setText(mActivity.getString(R.string.work_report)));
        tl_work.addTab(tl_work.newTab().setText(mActivity.getString(R.string.work_client)));
        tl_work.addTab(tl_work.newTab().setText(mActivity.getString(R.string.work_notice)));


        /**
         * 底部
         * @return
         */

        iv_add = findOAViewById(R.id.iv_add);


    }

    @Override
    protected void initListener() {

        iv_add.setOnClickListener(this);
    }

    @Override
    protected void onLazyLoad() {
        tl_work.getTabAt(ConstLocalData.TAB_INDEX_0).select();
        tv_left.setText(mActivity.getString(R.string.work_all));
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
        ToastUtil.showMsg(mActivity.getApplicationContext(), errorMsg);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {


        Log.i("select_Tab", " 选中" + tab.getText());

        presenterFgWork.doGetDifferentFragmentByPosition(tab.getPosition());
        tv_left.setText(tab.getText());

    }

    /**
     * 该方法 是释放之前被选中的项
     *
     * @param tab
     */
    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
//        Log.i("select_Tab"," 未选中"+tab.getText());
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
//        Log.i("select_Tab"," 释放"+tab.getText());
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.iv_add:





                openActivity(WorkAddActivity.class,null);
                break;
        }
    }
}
