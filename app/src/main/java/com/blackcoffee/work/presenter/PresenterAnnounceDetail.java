package com.blackcoffee.work.presenter;

import com.blackcoffee.work.method.IAnnounce;
import com.blackcoffee.work.ui.iview.IAnnounceDetialView;

/**
 * Created by admin on 2018/5/29.
 * 类描述
 * 版本
 */
public class PresenterAnnounceDetail extends BasePresenter<IAnnounceDetialView> {


    private IAnnounceDetialView iAnnounceDetialView;


    public PresenterAnnounceDetail(IAnnounceDetialView iAnnounceDetialView) {
        this.iAnnounceDetialView = iAnnounceDetialView;
    }
}