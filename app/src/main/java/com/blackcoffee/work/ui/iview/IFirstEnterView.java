package com.blackcoffee.work.ui.iview;

import com.blackcoffee.work.ui.IBasePermissionView;

/**
 * Created by admin on 2018/5/4.
 * 类描述  首页的回调view
 * 版本
 */
public interface IFirstEnterView extends IBasePermissionView{

    void doGoToWelcome();

    void doGoToMain();

    void  doGetPhoneConTact();
}