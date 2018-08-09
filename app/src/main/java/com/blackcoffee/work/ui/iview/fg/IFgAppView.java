package com.blackcoffee.work.ui.iview.fg;

import android.os.Bundle;

import com.blackcoffee.work.test.TestApplication;
import com.blackcoffee.work.test.TestApplicationMySection;
import com.blackcoffee.work.ui.IBaseView;

import java.util.List;

/**
 * Created by admin on 2018/5/9.
 * 类描述  应用的view
 * 版本
 */
public interface IFgAppView extends IBaseView {


    void dismissFreshLoading();

    void onDataBackFailInLoadMore(int code, String errorMsg);

    void onDataBackSuccessForGetAppConfig(List<TestApplicationMySection> testApplicationMySections);

    void onDataBackSuccessForGetAppConfigInFresh(List<TestApplicationMySection> testApplicationMySections);

    void onDataBackSuccessForGetAppConfigInLoadMore(List<TestApplicationMySection> testApplicationMySections);


    void doGoToNextActivity(Class<?> targetClass, Bundle bundle);
}