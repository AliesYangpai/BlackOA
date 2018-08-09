package com.blackcoffee.work.ui.fragment;


import android.os.Bundle;

import com.blackcoffee.work.R;
import com.blackcoffee.work.entity.EventEntity;
import com.blackcoffee.work.presenter.fg.PresenterFgContactGroupsMyInvite;
import com.blackcoffee.work.ui.BaseFragment;
import com.blackcoffee.work.ui.iview.fg.IFgContactGroupsMyInvitedView;
import com.blackcoffee.work.util.ToastUtil;


/**
 * 我的群组界面中 我加入的 fg
 */
public class FragmentContactGroupsMyInvited extends BaseFragment<IFgContactGroupsMyInvitedView,PresenterFgContactGroupsMyInvite> implements
        IFgContactGroupsMyInvitedView {



    public static final String TAG = FragmentContactGroupsMyInvited.class.getSimpleName();

    private PresenterFgContactGroupsMyInvite presenterFgContactGroupsMyInvite;

    public FragmentContactGroupsMyInvited() {
        // Required empty public constructor
    }



    @Override
    protected PresenterFgContactGroupsMyInvite creatPresenter() {

        if(null == presenterFgContactGroupsMyInvite) {
            presenterFgContactGroupsMyInvite = new PresenterFgContactGroupsMyInvite(this);
        }

        return presenterFgContactGroupsMyInvite;
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_contact_groups_my_invited;
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
