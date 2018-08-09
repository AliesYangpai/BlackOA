package com.blackcoffee.work.presenter;

import com.blackcoffee.work.ui.iview.ISearchPhoneNoView;

/**
 * Created by admin on 2018/5/30.
 * 类描述 查询电话号码的Presenter
 * 版本
 */
public class PresenterSearchPhoneNo extends BasePresenter<ISearchPhoneNoView> {


    private ISearchPhoneNoView iSearchPhoneNoView;

    public PresenterSearchPhoneNo(ISearchPhoneNoView iSearchPhoneNoView) {
        this.iSearchPhoneNoView = iSearchPhoneNoView;
    }
}