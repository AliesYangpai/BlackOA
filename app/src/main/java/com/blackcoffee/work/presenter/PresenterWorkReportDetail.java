package com.blackcoffee.work.presenter;

import com.blackcoffee.work.ui.iview.IWorkReportDetailView;

/**
 * Created by admin on 2018/5/29.
 * 类描述    工作汇报详情界面
 * 版本
 */
public class PresenterWorkReportDetail extends BasePresenter<IWorkReportDetailView> {

    private IWorkReportDetailView iWorkReportDetailView;


    public PresenterWorkReportDetail(IWorkReportDetailView iWorkReportDetailView) {
        this.iWorkReportDetailView = iWorkReportDetailView;
    }




}