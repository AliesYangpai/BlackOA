package com.blackcoffee.work.ui.iview.fg.child;

import com.blackcoffee.work.test.TestApplicationMySection;
import com.blackcoffee.work.test.TestWork;
import com.blackcoffee.work.ui.IBaseView;

import java.util.List;

/**
 * Created by admin on 2018/5/27.
 * 类描述  工作child 客户
 * 版本
 */
public interface IFgWorkChildClient extends IBaseView {


    void dismissFreshLoading();

    void onDataBackFailInLoadMore(int code, String errorMsg);

    void onDataBackSuccessForGetWorkClients(List<TestWork> testWorks);

    void onDataBackSuccessForGetWorkClientsInFresh(List<TestWork> testWorks);

    void onDataBackSuccessForGetWorkClientsInLoadMore(List<TestWork> testWorks);
}