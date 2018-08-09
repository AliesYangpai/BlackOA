package com.blackcoffee.work.presenter.fg;

import com.blackcoffee.work.presenter.BasePresenter;
import com.blackcoffee.work.ui.iview.fg.IFgConnectView;

/**
 * Created by admin on 2018/5/9.
 * 类描述  联系人fragment的界面管理者
 * 版本
 */
public class PresenterFgConnect extends BasePresenter<IFgConnectView> {

    private IFgConnectView iFgConnectView;


    public PresenterFgConnect(IFgConnectView iFgConnectView) {
        this.iFgConnectView = iFgConnectView;
    }



}