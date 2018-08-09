package com.blackcoffee.work.ui.iview;

import com.blackcoffee.work.ui.IBaseView;

/**
 * Created by admin on 2018/5/31.
 * 类描述  我的好友详情界面
 * 版本
 */
public interface IContactFriendDetialView extends IBaseView {


    void onVertifyErrorForNoPhoneNum();

    void onVertifyErrorForNoSimCard();

    void doGetTeleManager(String phone);


    void doCall(String phone);
}