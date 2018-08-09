package com.blackcoffee.work.presenter;

import com.blackcoffee.work.ui.iview.IWorkAddView;

/**
 * Created by admin on 2018/5/22.
 * 类描述
 * 版本
 */
public class PresenterWorkAdd extends BasePresenter<IWorkAddView> {


    private IWorkAddView iWorkAddView;


    public PresenterWorkAdd(IWorkAddView iWorkAddView) {
        this.iWorkAddView = iWorkAddView;
    }



}