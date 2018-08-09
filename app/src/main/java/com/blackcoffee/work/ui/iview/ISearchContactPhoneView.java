package com.blackcoffee.work.ui.iview;

import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.ui.IBaseView;

import java.util.List;

/**
 * Created by admin on 2018/5/31.
 * 类描述  手机通讯录中 进入到的搜于界面
 * 版本
 */
public interface ISearchContactPhoneView extends IBaseView {

    void onDataBackSuccessForContactPhoneSearch(List<SelfContact> selfContacts);


    void doSearchRecordsClear();
}