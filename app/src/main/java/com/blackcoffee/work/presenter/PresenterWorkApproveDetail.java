package com.blackcoffee.work.presenter;

import com.blackcoffee.work.ui.iview.IWorkApproveDetailView;
import com.blackcoffee.work.ui.iview.IWorkReportDetailView;

/**
 * Created by admin on 2018/5/29.
 * 类描述    审批详情界面
 * 版本
 */
public class PresenterWorkApproveDetail extends BasePresenter<IWorkApproveDetailView> {

    private IWorkApproveDetailView iWorkApproveDetailView;


    public PresenterWorkApproveDetail(IWorkApproveDetailView iWorkApproveDetailView) {
        this.iWorkApproveDetailView = iWorkApproveDetailView;
    }
}