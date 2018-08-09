package com.blackcoffee.work.presenter.fg;

import com.blackcoffee.work.presenter.BasePresenter;
import com.blackcoffee.work.ui.iview.fg.IFgAppView;
import com.blackcoffee.work.ui.iview.fg.IFgUserView;

/**
 * Created by admin on 2018/5/9.
 * 类描述  应用fragment的界面管理者
 * 版本
 */
public class PresenterFgUser extends BasePresenter<IFgUserView> {

    private IFgUserView iFgUserView;


    public PresenterFgUser(IFgUserView iFgUserView) {
        this.iFgUserView = iFgUserView;
    }


}