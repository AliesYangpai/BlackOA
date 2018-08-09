package com.blackcoffee.work.presenter;


import com.blackcoffee.work.ui.iview.IWelcomeView;



/**
 * Created by Alie on 2017/11/16.
 * 类描述  欢迎页的Prsenter
 * 版本
 */

public class PresenterWelcome extends BasePresenter<IWelcomeView> {

    private IWelcomeView iWelcomView;


    public PresenterWelcome(IWelcomeView iWelcomView) {
        this.iWelcomView = iWelcomView;
    }

    public void doGoToMain() {

        iWelcomView.doGoToLogin();

    }



}
