package com.blackcoffee.work.presenter;

import com.blackcoffee.work.ui.iview.fg.IFgReportDayScanView;

/**
 * Created by admin on 2018/6/8.
 * 类描述
 * 版本
 */
public class PresenterReportDayScan extends BasePresenter<IFgReportDayScanView> {

    private  IFgReportDayScanView iFgReportDayScanView;


    public PresenterReportDayScan(IFgReportDayScanView iFgReportDayScanView) {
        this.iFgReportDayScanView = iFgReportDayScanView;
    }
}


