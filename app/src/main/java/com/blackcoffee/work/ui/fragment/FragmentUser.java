package com.blackcoffee.work.ui.fragment;


import android.os.Bundle;

import com.blackcoffee.work.App;
import com.blackcoffee.work.R;
import com.blackcoffee.work.entity.EventEntity;
import com.blackcoffee.work.presenter.fg.PresenterFgUser;
import com.blackcoffee.work.ui.BaseFragment;
import com.blackcoffee.work.ui.iview.fg.IFgUserView;
import com.blackcoffee.work.util.ToastUtil;

/**
 * 用户fragment
 */
public class FragmentUser extends BaseFragment<IFgUserView,PresenterFgUser> implements IFgUserView{

    public static final String TAG = FragmentUser.class.getSimpleName();
    private PresenterFgUser presenterFgUser;

    @Override
    protected PresenterFgUser creatPresenter() {
        if(null == presenterFgUser) {

            presenterFgUser = new PresenterFgUser(this);
        }

        return presenterFgUser;
    }

    @Override
    protected int setLayoutResouceId() {

        return R.layout.fragment_user;
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
        ToastUtil.showMsg(App.getInstance().getApplicationContext(),errorMsg);
    }
}
