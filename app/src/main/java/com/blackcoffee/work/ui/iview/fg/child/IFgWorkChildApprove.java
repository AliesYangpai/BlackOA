package com.blackcoffee.work.ui.iview.fg.child;

import com.blackcoffee.work.test.TestWork;
import com.blackcoffee.work.ui.IBaseView;

import java.util.List;

/**
 * Created by admin on 2018/5/27.
 * 类描述  工作child 审批
 * 版本
 */
public interface IFgWorkChildApprove  extends IBaseView {


    void dismissFreshLoading();

    void onDataBackFailInLoadMore(int code, String errorMsg);

    void onDataBackSuccessForGetWorkApproves(List<TestWork> testWorks);

    void onDataBackSuccessForGetWorkApprovesInFresh(List<TestWork> testWorks);

    void onDataBackSuccessForGetWorkApprovesInLoadMore(List<TestWork> testWorks);
}