package com.blackcoffee.work.ui.fragment;


import android.os.Bundle;

import com.blackcoffee.work.R;
import com.blackcoffee.work.entity.EventEntity;
import com.blackcoffee.work.presenter.fg.PresenterFgContactGroupsMyCreate;
import com.blackcoffee.work.ui.BaseFragment;
import com.blackcoffee.work.ui.iview.fg.IFgContactGroupsMyCreateView;
import com.blackcoffee.work.util.ToastUtil;


/**
 * 我的群组界面中 我创建的 fg
 */
public class FragmentContactGroupsMyCreate extends BaseFragment<IFgContactGroupsMyCreateView,PresenterFgContactGroupsMyCreate> implements
        IFgContactGroupsMyCreateView {


    public static final String TAG = FragmentContactGroupsMyCreate.class.getSimpleName();


    private PresenterFgContactGroupsMyCreate presenterFgContactGroupsMyCreate;

    public FragmentContactGroupsMyCreate() {
        // Required empty public constructor
    }



    @Override
    protected PresenterFgContactGroupsMyCreate creatPresenter() {

        if(null == presenterFgContactGroupsMyCreate) {
            presenterFgContactGroupsMyCreate = new PresenterFgContactGroupsMyCreate(this);
        }

        return presenterFgContactGroupsMyCreate;
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_contact_group_my_create;
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
