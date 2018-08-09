package com.blackcoffee.work.presenter;

import com.blackcoffee.work.ui.iview.IContactPhoneDetialView;

/**
 * Created by admin on 2018/5/31.
 * 类描述  联系人详情界面
 * 版本
 */
public class PresenterContactPhoneDetail extends BasePresenter<IContactPhoneDetialView> {

    private IContactPhoneDetialView iContactPhoneDetialView;

    public PresenterContactPhoneDetail(IContactPhoneDetialView iContactPhoneDetialView) {
        this.iContactPhoneDetialView = iContactPhoneDetialView;
    }
}