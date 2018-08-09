package com.blackcoffee.work.presenter;

import com.blackcoffee.work.method.IWorkCheckAbout;
import com.blackcoffee.work.ui.iview.ICheckInView;

/**
 * Created by admin on 2018/6/4.
 * 类描述  打卡的presenter
 * 版本
 */
public class PresenterCheckIn extends BasePresenter<ICheckInView> {

    private ICheckInView iCheckInView;
    private IWorkCheckAbout iWorkCheckAbout;


    public PresenterCheckIn(ICheckInView iCheckInView) {
        this.iCheckInView = iCheckInView;
    }
}