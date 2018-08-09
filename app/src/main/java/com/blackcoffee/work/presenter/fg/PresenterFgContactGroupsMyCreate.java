package com.blackcoffee.work.presenter.fg;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.blackcoffee.work.presenter.BasePresenter;
import com.blackcoffee.work.ui.iview.fg.IFgContactGroupsMyCreateView;
import com.blackcoffee.work.universal.mgr.FgContactGroupMgr;

/**
 * Created by admin on 2018/6/1.
 * 类描述  我的群组中 “我创建的” presenter
 * 版本
 */
public class PresenterFgContactGroupsMyCreate extends BasePresenter<IFgContactGroupsMyCreateView> {

    private IFgContactGroupsMyCreateView iFgContactGroupsMyCreateView;

    public PresenterFgContactGroupsMyCreate(IFgContactGroupsMyCreateView iFgContactGroupsMyCreateView) {
        this.iFgContactGroupsMyCreateView = iFgContactGroupsMyCreateView;
    }






}