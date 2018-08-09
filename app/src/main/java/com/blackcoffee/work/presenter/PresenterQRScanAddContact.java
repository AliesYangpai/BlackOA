package com.blackcoffee.work.presenter;

import com.blackcoffee.work.ui.iview.IQRScanAddContactView;

/**
 * Created by admin on 2018/5/30.
 * 类描述
 * 版本
 */
public class PresenterQRScanAddContact extends BasePresenter<IQRScanAddContactView> {


    private IQRScanAddContactView IQRScanAddContactView;


    public PresenterQRScanAddContact(IQRScanAddContactView IQRScanAddContactView) {
        this.IQRScanAddContactView = IQRScanAddContactView;
    }
}