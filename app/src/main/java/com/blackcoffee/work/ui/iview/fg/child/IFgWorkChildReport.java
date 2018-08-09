package com.blackcoffee.work.ui.iview.fg.child;

import com.blackcoffee.work.test.TestWork;
import com.blackcoffee.work.ui.IBaseView;

import java.util.List;

/**
 * Created by admin on 2018/5/27.
 * 类描述  工作child 汇报
 * 版本
 */
public interface IFgWorkChildReport extends IBaseView {

    void dismissFreshLoading();

    void onDataBackFailInLoadMore(int code, String errorMsg);

    void onDataBackSuccessForGetWorkReports(List<TestWork> testWorks);

    void onDataBackSuccessForGetWorkReportsInFresh(List<TestWork> testWorks);

    void onDataBackSuccessForGetWorkReportsInLoadMore(List<TestWork> testWorks);

}