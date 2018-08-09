package com.blackcoffee.work.ui.iview;

import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.test.TestApplicationMySection;
import com.blackcoffee.work.ui.IBaseView;

import java.util.List;

/**
 * Created by admin on 2018/5/31.
 * 类描述  获取我的好友
 * 版本
 */
public interface IContactFriendsView extends IBaseView {

    void dismissFreshLoading();

    void onDataBackFailInLoadMore(int code, String errorMsg);

    void onDataBackSuccessForGetFriends(List<TestApplicationMySection> testApplicationMySections);

//    void onDataBackSuccessForGetFriendsInFresh(List<TestApplicationMySection> testApplicationMySections);
//
//    void onDataBackSuccessForGetFriendsInLoadMore(List<TestApplicationMySection> testApplicationMySections);












    void doShowSelfContactFromDb(List<SelfContact> selfContacts);

    void onVertifyErrorNoContacts();
}