package com.blackcoffee.work.ui.iview.fg.child;

import com.blackcoffee.work.test.TestWork;
import com.blackcoffee.work.ui.IBaseView;

import java.util.List;

/**
 * Created by admin on 2018/5/27.
 * 类描述  工作child 全部
 * 版本
 */
public interface IFgWorkChildAll extends IBaseView {

    void dismissFreshLoading();

    void onDataBackFailInLoadMore(int code, String errorMsg);

    void onDataBackSuccessForGetWorkAll(List<TestWork> testWorks);

    void onDataBackSuccessForGetWorkAllInFresh(List<TestWork> testWorks);

    void onDataBackSuccessForGetWorkAllInLoadMore(List<TestWork> testWorks);
}