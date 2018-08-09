package com.blackcoffee.work.ui.iview.fg.child;

import com.blackcoffee.work.test.TestWork;
import com.blackcoffee.work.ui.IBaseView;

import java.util.List;

/**
 * Created by admin on 2018/5/27.
 * 类描述  工作child 公告
 * 版本
 */
public interface IFgWorkChildAnnounce extends IBaseView {


    void dismissFreshLoading();

    void onDataBackFailInLoadMore(int code, String errorMsg);

    void onDataBackSuccessForGetWorkAnnounces(List<TestWork> testWorks);

    void onDataBackSuccessForGetWorkAnnouncesInFresh(List<TestWork> testWorks);

    void onDataBackSuccessForGetWorkAnnouncesInLoadMore(List<TestWork> testWorks);
}